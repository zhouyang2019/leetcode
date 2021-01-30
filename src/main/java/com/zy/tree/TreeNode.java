package com.zy.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTreeNode(Integer[] a) {
        if (a == null || a.length < 1 || a[0] == null) {
            return null;
        }
        if (a.length == 1) {
            return new TreeNode(a[0]);
        }

        TreeNode[] nodes = new TreeNode[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new TreeNode(a[i]);
            }
        }

        int lastParent = (a.length - 2) / 2;
        for (int i = 0; i < lastParent; i++) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[2 * i + 1];
                nodes[i].right = nodes[2 * i + 2];
            }
        }
        nodes[lastParent].left = nodes[2 * lastParent + 1];
        if (2 * lastParent + 2 < a.length) {
            nodes[lastParent].right = nodes[2 * lastParent + 2];
        }
        return nodes[0];
    }
}
