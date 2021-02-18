package com.zy.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvertTreeTest {

    InvertTree invertTree = new InvertTree();
    TreeNode root = TreeNode.createTreeNode(new Integer[]{4,2,7,1,3,6,9});

    @Test
    public void test_invertTree() {
        System.out.println(TreeTraverse.levelTraverse(root));
        System.out.println(TreeTraverse.levelTraverse(invertTree.invertTree(root)));
    }
}