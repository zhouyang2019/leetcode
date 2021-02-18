package com.zy.tree;

import org.junit.Test;

import static com.zy.tree.TreeTraverse.*;

public class TreeTraverseTest {

    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public static TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});

    @Test
    public void test_preOrderTraverse() {
        System.out.println(preOrderTraverse1(root));
        System.out.println(preOrderTraverse2(root));
    }

    @Test
    public void test_inOrderTraverse() {
        System.out.println(inOrderTraverse1(root));
        System.out.println(inOrderTraverse2(root));
    }

    @Test
    public void test_postOrderTraverse() {
        System.out.println(postOrderTraverse1(root));
        System.out.println(postOrderTraverse2(root));
        TreeNode root2 = TreeNode.createTreeNode(new Integer[]{3,9,20,1,2,15,7,3,4});
        System.out.println(postOrderTraverse1(root2));
    }

    @Test
    public void test_levelTraverse() {
        System.out.println(levelTraverse(root));
    }

    @Test
    public void test_depthOrderTraverse() {
        System.out.println(depthOrderTraverse(root));
    }

}