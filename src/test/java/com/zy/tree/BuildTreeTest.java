package com.zy.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuildTreeTest {

    BuildTree obj = new BuildTree();

    @Test
    public void test_buildTree() {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = obj.buildTree(inorder, postorder);
        System.out.println(TreeTraverse.levelTraverse(root));
        System.out.println(TreeTraverse.levelTraverse(obj.buildTree(new int[]{1}, new int[]{1})));
        System.out.println(TreeTraverse.levelTraverse(obj.buildTree(new int[]{2,1}, new int[]{2,1})));
        System.out.println(TreeTraverse.levelTraverse(obj.buildTree(new int[]{1,2}, new int[]{2,1})));
    }

    @Test
    public void test_buildTreeByPre() {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        System.out.println(TreeTraverse.levelTraverse(obj.buildTreeByPre(preorder, inorder)));
        System.out.println(TreeTraverse.levelTraverse(obj.buildTreeByPre(new int[]{1}, new int[]{1})));
        System.out.println(TreeTraverse.levelTraverse(obj.buildTreeByPre(new int[]{1,2}, new int[]{2,1})));
        System.out.println(TreeTraverse.levelTraverse(obj.buildTreeByPre(new int[]{1,2}, new int[]{1,2})));
    }

    @Test
    public void test_constructMaximumBinaryTree() {
        System.out.println(TreeTraverse.levelTraverse(obj.constructMaximumBinaryTree(new int[]{3,2,1})));
        System.out.println(TreeTraverse.levelTraverse(obj.constructMaximumBinaryTree(new int[]{2,4,0,3,1})));
        System.out.println(TreeTraverse.levelTraverse(obj.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5})));
    }
}