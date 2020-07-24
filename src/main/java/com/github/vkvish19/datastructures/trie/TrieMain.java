package com.github.vkvish19.datastructures.trie;

public class TrieMain
{
    public static void main(String[] args)
    {
        Trie trie = new Trie();
        System.out.println("trie.isEmpty() = " + trie.isEmpty());
    
        trie.insert("antigen");
        trie.insert("hello");
        trie.insert("again");
    
        String s = "anti";
//        System.out.println("S:"+trie.getMatchingPrefix(s)+":");
        System.out.println("is deleted ? " + trie.delete("anti"));
    
        System.out.println("trie.containsNode(\"anti\") = " + trie.containsNode("anti"));
        System.out.println("trie.containsNode(\"antigen\") = " + trie.containsNode("antigen"));
        System.out.println("trie.getMatchingPrefix(\"antig\") = " + trie.getMatchingPrefix("antig"));
    }
}
