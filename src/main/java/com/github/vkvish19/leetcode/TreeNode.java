package com.github.vkvish19.leetcode;

import java.util.List;

public class TreeNode {
    int val;
    List<TreeNode> children;
    
    public TreeNode() {}
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, List<TreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
