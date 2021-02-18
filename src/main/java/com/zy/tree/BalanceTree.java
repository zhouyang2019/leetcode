package com.zy.tree;

/**
 * 平衡二叉树：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class BalanceTree {

    /**
     * 110. 平衡二叉树   https://leetcode-cn.com/problems/balanced-binary-tree/
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return depth(root) != -1;
    }
    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        if(left == -1)
            return -1;
        int right = depth(root.right);
        if(right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


}
