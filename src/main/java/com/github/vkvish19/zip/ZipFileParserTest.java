package com.github.vkvish19.zip;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipFileParserTest
{
    public static void main(String[] args)
    {
        String resXml = "";
        String resPlr = "";
        File file = new File("/home/vishu/Learnings/VishuMaven/src/main/resources/vishu.zip");
        try(ZipFile zipFile = new ZipFile(file, ZipFile.OPEN_READ))
        {
            InputStream is = null;
            is = new BufferedInputStream(new FileInputStream(file));
            
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry ze;
            ZipEntry zeXml = null;
            ZipEntry zePlr = null;
            String innerFilename = null;
            while((ze = zis.getNextEntry()) != null)
            {
                innerFilename = ze.getName();
                if(innerFilename.equals("vishu2.plr"))
                {
                    zePlr = ze;
                }
                if(innerFilename.equals("vishu1.xml"))
                {
                    zeXml = ze;
                }
            }
            resXml = parsePlrAndXml(zeXml);
            resPlr = parsePlrAndXml(zePlr);
            System.out.println("resPlr in main= " + resPlr);
            System.out.println("resXml in main= " + resXml);
        }
        catch(IOException e)
        {
            System.out.println("e.getMessage() = " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    private static String parsePlrAndXml(ZipEntry ze)
    {
        if(ze.getName().equals("vishu2.plr"))
        {
            return "plrsuccess";
        }
        if(ze.getName().equals("vishu1.xml"))
        {
            return "xmlsuccess";
        }
        return "nooooo";
    }
}
