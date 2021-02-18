package com.zy.tree;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (p == root) || (q == root)) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && (right == null)) {
            return null;
        }
        if (left == null && (right != null)) {
            return right;
        }
        if (left != null && (right == null)) {
            return left;
        }
        return root;
    }

}
