package com.github.vkvish19.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TruncateSentence
{
    public static void main(String[] args)
    {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String sentence = br.readLine();
            int k = Integer.parseInt(br.readLine());
            System.out.println(truncateSentence(sentence, k));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static String truncateSentence(String s, int k)
    {
//        StringBuilder sb = new StringBuilder();
        
        
        // with split
        String[] words = s.split(" ");
        if(k == words.length)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++)
        {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
