package com.zy.tree;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode {

    public int val;
    public List<NTreeNode> children;

    public NTreeNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        NTreeNode root = createNTreeNode(new Integer[]{1,3,2,4,5,6}, 3);
        print(root);
    }

    public static NTreeNode createNTreeNode(Integer[] a, int n) {
        if (a == null || a.length < 1 || a[0] == null) {
            return null;
        }
        if (a.length == 1) {
            return new NTreeNode(a[0]);
        }

        NTreeNode[] nodes = new NTreeNode[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                nodes[i] = null;
            } else {
                nodes[i] = new NTreeNode(a[i]);
            }
        }

        int lastParent = (a.length - 2) / n;
        for (int i = 0; i < lastParent; i++) {
            if (nodes[i] != null) {
                List<NTreeNode> children = new ArrayList<>();
                for (int j = 1; j <= n; j++) {
                    children.add(nodes[n * i + j]);
                }
                nodes[i].children = children;
            }
        }

        List<NTreeNode> children = new ArrayList<>();
        int childrenNum = (a.length - 2) % n + 1;
        for (int i = 0; i < childrenNum; i++) {
            children.add(i, nodes[n * lastParent + i + 1]);
        }
        nodes[lastParent].children = children;
        return nodes[0];
    }

    public static void print(NTreeNode root) {
        NTreeTraverse traverse = new NTreeTraverse();
        System.out.println(traverse.levelOrder(root));
        System.out.println(traverse.preorder(root));
    }

}
