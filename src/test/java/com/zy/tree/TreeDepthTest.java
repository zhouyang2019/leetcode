package com.zy.tree;

import org.junit.Test;

public class TreeDepthTest {

    TreeDepth treeDepth = new TreeDepth();
    TreeNode root = TreeTraverseTest.root;

    @Test
    public void test_maxDepth() {
        System.out.println(treeDepth.maxDepth(root));
        System.out.println(treeDepth.maxDepth2(root));
    }

    @Test
    public void test_ntreeMaxDepth() {
        NTreeNode root = NTreeNode.createNTreeNode(new Integer[]{1,3,2,4,5,6}, 3);
        System.out.println(treeDepth.ntreeMaxDepth(root));
    }

    @Test
    public void test_minDepth() {
        System.out.println(treeDepth.minDepth(root));
        System.out.println(treeDepth.minDepth2(root));
        TreeNode root2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root2.right = node3;
        TreeNode node4 = new TreeNode(4);
        node3.right = node4;
        TreeNode node5 = new TreeNode(5);
        node4.right = node5;
        TreeNode node6 = new TreeNode(6);
        node5.right = node6;
        System.out.println(treeDepth.minDepth(root2));
        System.out.println(treeDepth.minDepth2(root2));
    }
}