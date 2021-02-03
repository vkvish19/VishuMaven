package com.github.vkvish19.hackerrank;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RansomNote
{
    public static void main(String[] args) throws MalformedURLException
    {
        String s = "http://localhost:8080/abc/xyz.zc";
        String ss = "https://localhost:443/abc/xyz.zc";
        URL url = new URL(s);
        URL url1 = new URL(ss);
    
    
        System.out.println("url.getProtocol() = " + url.getProtocol());
        System.out.println("url1.getProtocol() = " + url1.getProtocol());
        System.out.println("url.getPath() = " + url.getPath());
        System.out.println("url1.getPath() = " + url1.getPath());
    }
}