package com.zy.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTreeTest {

    MergeTree obj = new MergeTree();

    @Test
    public void test_mergeTrees() {
        TreeNode t1 = TreeNode.createTreeNode(new Integer[]{1,3,null,5});
        TreeNode t2 = TreeNode.createTreeNode(new Integer[]{2,1,3});
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees(t1, t2)));
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees2(t1, t2)));
    }
    @Test
    public void test_mergeTrees2() {
        TreeNode t1 = TreeNode.createTreeNode(new Integer[]{1,3,2,5});
        TreeNode t2 = TreeNode.createTreeNode(new Integer[]{2,1,3,null,4,null,7});
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees(t1, t2)));
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees2(t1, t2)));
    }
    @Test
    public void test_mergeTrees3() {
        TreeNode t1 = TreeNode.createTreeNode(new Integer[]{});
        TreeNode t2 = TreeNode.createTreeNode(new Integer[]{2,1,3,null,4,null,7});
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees(t1, t2)));
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees2(t1, t2)));
    }
    @Test
    public void test_mergeTrees4() {
        TreeNode t1 = TreeNode.createTreeNode(new Integer[]{1,2,null,3});
        TreeNode t2 = TreeNode.createTreeNode(new Integer[]{1,null,2,null,null,null,3});
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees(t1, t2)));
        System.out.println(TreeTraverse.levelTraverse(obj.mergeTrees2(t1, t2)));
    }
}