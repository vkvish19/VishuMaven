package com.github.vkvish19.datastructures.trie;

import java.util.Map;

public class Trie
{
    private TrieNode root;
    
    public Trie()
    {
        root = new TrieNode();
    }
    
    public void insert(String word)
    {
        TrieNode current = root;
        for(char c : word.toCharArray())
        {
            current = current.getChildren().computeIfAbsent(c, l -> new TrieNode());
        }
        current.setEndOfWord(true);
    }
    
    public boolean containsNode(String word)
    {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++)
        {
            TrieNode node = current.getChildren().get(word.charAt(i));
            if(node == null)
                return false;
            current = node;
        }
        return current.isEndOfWord();
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }

    public boolean delete(String word)
    {
        return delete(root, word, 0);
    }
    
    private boolean delete(TrieNode current, String word, int index)
    {
        if(index == word.length())
        {
            // this means it has children, so wont delete
            if(!current.isEndOfWord())
            {
                return false;
            }
    
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if(node == null)
            return false;
        
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();
        if(shouldDeleteCurrentNode)
        {
            current.getChildren().remove(ch);
            System.out.println("word= " + word + ", index= " + index + ",current.getChildren() = " + current.getChildren());
            return current.getChildren().isEmpty();
        }
        return false;
    }
    
    public String getMatchingPrefix(String word)
    {
        StringBuilder result = new StringBuilder(); // Initialize resultant string
        int length = word.length(); // Find length of the input string
        
        // Initialize reference to traverse through Trie
        TrieNode crawl = root;
        
        // Iterate through all characters of input string 'str' and traverse
        // down the Trie
//        int level;
        int prevMatch = 0;
        for(int level = 0; level < length; level++)
        {
            // Find current character of str
            char ch = word.charAt(level);
            
            // HashMap of current Trie node to traverse down
            Map<Character,TrieNode> child = crawl.getChildren();
            
            // See if there is a Trie edge for the current character
            if(child.containsKey(ch))
            {
                result.append(ch);         //Update result
                crawl = child.get(ch); //Update crawl to move down in Trie
                
                // If this is end of a word, then update prevMatch
                if(crawl.isEndOfWord())
                    prevMatch = level + 1;
            }
            else break;
        }
        System.out.println("word: " + word + ", prevMatch = " + prevMatch);
        
        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if(!crawl.isEndOfWord())
            return result.substring(0, prevMatch);
        
        else
            return result.toString();
    }
}
