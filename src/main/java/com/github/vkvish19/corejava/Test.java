package com.github.vkvish19.corejava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test
{
    private static String jmxParamFormatExt = "-Dcom.novell.zenworks.jmxremote.port=%s "
            + "-Dcom.sun.management.jmxremote.ssl.enabled.protocols=%s "
            + "-Dcom.sun.management.jmxremote.ssl.enabled.cipher.suites=%s "
            + "-Dcom.sun.management.jmxremote.ssl=true -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl.need.client.auth=true -Dsun.rmi.transport.tcp.responseTimeout=60000";
    
    
    public static void main(String[] args) throws Exception
    {
        String appendTo = "JMX_OPTS";
        String optionName = "ZEN_JMX_OPTS";
        String cipher = "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,TLS_RSA_WITH_AES_128_GCM_SHA256,TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256,TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256,TLS_DHE_RSA_WITH_AES_128_GCM_SHA256,TLS_DHE_DSS_WITH_AES_128_GCM_SHA256,TLS_DHE_DSS_WITH_AES_128_CBC_SHA256,TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256";
        String optionValue = String.format(jmxParamFormatExt, 61498, "TLSv1,TLSv1.1,TLSv1.2,SSLv2Hello", cipher);
        String path = "/tmp/vkktest1.txt";
        
        String value = optionName + "=\"" + optionValue + "\"";
        String content = loadFileToString(path);
        System.out.println("content = " + content);
    
        String[] contentLines = content.split("\\n");
        StringBuffer newContent = new StringBuffer();
    
        boolean modified = false;
    
        for(String line : contentLines)
        {
            if(line.startsWith(optionName) && !modified)
            {
                break;
            }
        
            if(line.startsWith(appendTo))
            {
                newContent.append(value + "\n");
                String rep = line.replaceFirst(appendTo + "=\"", appendTo + "=\"\\$" + optionName + " ");
                newContent.append(rep + "\n");
                modified = true;
            }
            else
            {
                newContent.append(line + "\n");
            }
        }
    
        if(modified)
        {
            saveStringToFile(newContent.toString(), path);
        }
        System.out.println("************************************************");
        
    }
    
    public static String loadFileToString(String filePath) throws IOException
    {
        BufferedReader reader = null;
        
        try
        {
            StringBuffer buffer = new StringBuffer();
            reader = new BufferedReader(new FileReader(filePath));
            int temp;
            
            while((temp = reader.read()) != -1)
            {
                buffer.append((char)temp);
            }
            
            return buffer.toString();
        }
        finally
        {
            if(reader != null)
            {
                reader.close();
            }
        }
    }
    
    public static void saveStringToFile(String contents, String fileName) throws IOException
    {
        BufferedWriter writer = null;
        try
        {
            File temp = new File(fileName);
            if(temp.getParentFile() != null)
            {
                temp.getParentFile().mkdirs();
            }
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            writer.write(contents);
        }
        finally
        {
            if(writer != null)
            {
                writer.close();
            }
        }
    }
    
    
}
