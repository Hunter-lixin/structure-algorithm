package com.LeetCode;

public class TreeNode {
    int val;
    com.LeetCode.TreeNode left;
    com.LeetCode.TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, com.LeetCode.TreeNode left, com.LeetCode.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
