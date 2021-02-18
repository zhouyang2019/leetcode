package com.zy.tree;

public class SumOfLeftLeaves {

    /**
     * 404. Sum of Left Leaves  https://leetcode-cn.com/problems/sum-of-left-leaves/
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return postTraverse(root);
    }

    private int postTraverse(TreeNode root) {
        int sum = 0;
        if (root != null) {
            TreeNode leftNode = root.left;
            // 判断 leftNode 是否为左叶子节点
            if (leftNode != null && (leftNode.left == null && leftNode.right == null)) {
                sum += leftNode.val;
            }
            sum += postTraverse(root.left);
            sum += postTraverse(root.right);
        }
        return sum;
    }

}
