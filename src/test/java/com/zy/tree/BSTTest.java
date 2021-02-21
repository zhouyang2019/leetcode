package com.zy.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

    BST obj = new BST();

    @Test
    public void test_getMinimumDifference() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{1,null,3,null,null,2});
        System.out.println(obj.getMinimumDifference(root));
    }
}