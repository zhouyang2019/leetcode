package com.zy.tree;

public class BinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        if (val< root.val) {
            return searchBST(root.left, val);
        }
        return root;
    }

}
