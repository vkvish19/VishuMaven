package com.github.vkvish19.jwt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTCreator
{
    public static final String MARKER_STRING = "clhd";
    public static final int HEADER_SIZE_LENGTH = 4;
    public static void main(String[] args) throws IOException
    {
        File file = new File("/home/vishu/Learnings/VishuMaven/src/main/resources/jwt/b7b3b6cd66c37349a03d187bf0740c79.zip");
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        createFileWithToken(fileBytes, true);
        
        //        String jwtToken = generateJwtToken(fileBytes);
    }
    
    private static String generateJwtToken(byte[] fileBytes)
    {
        //        Algorithm algorithm = Algorithm.HMAC512("13ad71e337c63a4ffc5b3e808e5ad77315");  // vishu54
        Algorithm algorithm = Algorithm.HMAC512("secret");  // VishuMssqlDb1
        String checksum = getChecksum(fileBytes);
        String token = JWT.create()
                .withClaim("version", "1")
                .withClaim("timestamp", "kuch_bhi")
                .withClaim("checksum", checksum)
                .withClaim("deviceguid", "b7b3b6cd66c37349a03d187bf0740c77")
                .sign(algorithm);
        
        System.out.println("token = " + token);
        return token;
    }
    
    private static String getChecksum(byte[] fileBytes)
    {
        try(ByteArrayInputStream bais = new ByteArrayInputStream(fileBytes))
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            DigestInputStream dis = new DigestInputStream(bais, md);
            byte[] tmp = new byte[100];
            int len;
            while( (len = dis.read(tmp)) != -1) {}
            return DatatypeConverter.printHexBinary( dis.getMessageDigest().digest() );
        }
        catch(Exception e)
        {
            System.out.println("Error occurred while fetching checksum : " + e.getMessage());
            return "";
        }
    }
    
    private static byte[] getHeaderContents(byte[] fileBytes)
    {
        byte[] markerBytes = MARKER_STRING.getBytes();
        String jwtString = generateJwtToken(fileBytes);
        int headerSize = jwtString.getBytes().length;
        byte[] headerSizeBytes = ByteBuffer.allocate(Integer.BYTES).order(ByteOrder.BIG_ENDIAN).putInt(headerSize).array();
        byte[] headerContentBytes;
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            baos.write(markerBytes);
            baos.write(headerSizeBytes);
            baos.write(jwtString.getBytes());
                        if(true)
                        {
                            baos.write("garbage".getBytes());   // adding garbage bytes to the header contents.
                        }
            headerContentBytes = baos.toByteArray();
        }
        catch(Exception e)
        {
            System.out.println("Error while getting header contents : " + e.getMessage());
            return new byte[0];
        }
        return headerContentBytes;
    }
    
    private static void createFileWithToken(byte[] bytes, boolean isHeaderNeeded)
    {
        try(FileOutputStream fos = new FileOutputStream(new File("/home/vishu/Learnings/VishuMaven/src/main/resources/jwt-with-token/b7b3b6cd66c37349a03d187bf0740c79.zip")))
        {
            if(isHeaderNeeded)
            {
                byte[] headerContentBytes = getHeaderContents(bytes);
                fos.write(headerContentBytes);
            }
            
            fos.write(bytes);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
