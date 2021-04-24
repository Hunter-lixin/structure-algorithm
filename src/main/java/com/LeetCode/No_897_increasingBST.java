package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No_897_increasingBST {
    private List<Integer> res = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        orderBST(root);

        TreeNode dump = new TreeNode(-1);
        TreeNode curr = dump;
        for (Integer value : res) {
            curr.right = new TreeNode(value);
            curr = curr.right;
        }
        return dump.right;
    }

    private void orderBST(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        orderBST(treeNode.left);
        res.add(treeNode.val);
        orderBST(treeNode.right);
    }

}




