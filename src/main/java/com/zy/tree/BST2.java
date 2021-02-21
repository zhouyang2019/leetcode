package com.zy.tree;

public class BST2 {

    /**
     * 701. Insert into a Binary Search Tree
     * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
     *
     * 思路：中序遍历找到第一个大于 val 的节点 node，将 val 插入为 node 的左儿子；如果 node 没找到，则将 val 插入为最后一个节点的右儿子
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (inOrderTraverseInsert(root, val) == null) {
                TreeNode p = root;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = new TreeNode(val);
            }
        }
        return root;
    }

    private TreeNode inOrderTraverseInsert(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode leftResult = inOrderTraverseInsert(root.left, val);
        if (leftResult != null) {
            return leftResult;
        }

        if (root.val > val) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root.left;
            root.left = newNode;
            return newNode;
        }

        TreeNode rightResult = inOrderTraverseInsert(root.right, val);
        if (rightResult != null) {
            return rightResult;
        }

        return null;
    }

    /**
     * 思路2：找到合适的空节点直接插入即可
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST2(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST2(root.right, val);
        }

        return root;
    }

}
