package com.github.vkvish19.corejava;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Scratch {
    private static volatile int i = 0;
    private static volatile int errorCount = 0;
    public static void main(String[] args) throws InterruptedException {
        largeAttack();
        System.out.println("Large Attack completed...");
        System.out.println("success count = " + i);
        System.out.println("error count = " + errorCount);
    }
    private static void largeAttack() throws InterruptedException {
        long start = System.currentTimeMillis();
        Runnable runnable = () ->
        {
            for( int i=0; i<100; i++ )
            {
                try {
                    executeFileUpload();
                } catch (IOException e) {
                    errorCount++;
                    e.printStackTrace();
                }
            }
        };
        List<Thread> threads = new ArrayList<>();
        for( int i=0; i<500; i++ )
            threads.add( new Thread( runnable ) );
        threads.forEach( Thread::start );
        for( Thread thread : threads )
            thread.join();
        System.out.println("done in " + (System.currentTimeMillis() - start) + " ms");
    }
    private static void executeFileUpload() throws IOException {
        HttpClient httpClient = getHttpClient();
        PostMethod postMethod = getPostMethod();
        httpClient.executeMethod(postMethod);
        System.out.println(++i + ". Got response code- " +postMethod.getStatusCode());
    }
    private static HttpClient getHttpClient()
    {
        HttpClient httpClient1 = new HttpClient(new MultiThreadedHttpConnectionManager());
        httpClient1.setHostConfiguration(new HostConfiguration());
        HttpConnectionManager connMgr = httpClient1.getHttpConnectionManager();
        HttpConnectionManagerParams connParams = connMgr.getParams();
        connParams.setConnectionTimeout(100 * 1000);
        connParams.setDefaultMaxConnectionsPerHost(10);
        connParams.setSoTimeout(2 * 60 * 1000);
        connMgr.setParams(connParams);
        return httpClient1;
    }
    private static PostMethod getPostMethod()
    {
        PostMethod postMethod = new PostMethod("http://10.71.64.124/zenworks-fileupload/");
        postMethod.setRequestHeader("host","M2-SLES11SP3-86-36.labs.blr.novell.com");
        postMethod.setRequestHeader("Content-Type","application/octet-stream");
        postMethod.setRequestHeader("Authorization",getAuthToken());
        postMethod.setQueryString(getQueryString());
        return postMethod;
    }
    private static NameValuePair[] getQueryString()
    {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new NameValuePair("type", "inventory"));
        nameValuePairs.add(new NameValuePair("overwrite", "true"));
        nameValuePairs.add(new NameValuePair("filename", "abc.txt"));
        NameValuePair[] params = new NameValuePair[nameValuePairs.size()];
        return nameValuePairs.toArray(params);
    }
    private static String getAuthToken()
    {
        String token = "77c36c7836633849dc7f4dc0cf9ec4e0:-6db8beaa56ebc22ea55aa4c71bcdb95717f9e26bae7e32d2";
        byte[] encodedBytes = Base64.getEncoder().encode(token.getBytes());
        return  "Basic " + new String(encodedBytes);
    }
}