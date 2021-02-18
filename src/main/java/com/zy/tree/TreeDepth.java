package com.zy.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeDepth {

    /**
     * 二叉树的最大深度：二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 104. 二叉树的最大深度    https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 迭代法：最大深度就是「层次遍历」的层数
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * N 叉树的最大深度
     */
    public int ntreeMaxDepth(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        List<NTreeNode> children = root.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                int depth = ntreeMaxDepth(children.get(i));
                maxDepth = depth > maxDepth ? depth : maxDepth;
            }
        }
        return ++maxDepth;
    }

    /**
     * 二叉树的最小深度：最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 111. 二叉树的最小深度    https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && (root.right != null)) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null && (root.left != null)) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 迭代法
     */
    public int minDepth2(TreeNode root) {
        int minDepth = 0;
        if (root == null) {
            return minDepth;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 终止条件：左右子节点都为空
                if (node.left == null && (node.right == null)) {
                    return ++minDepth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ++minDepth;
        }
        return minDepth;
    }

}
