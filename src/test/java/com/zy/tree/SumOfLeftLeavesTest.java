package com.zy.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfLeftLeavesTest {

    @Test
    public void sumOfLeftLeaves() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3,9,20,null,null,15,7});
        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        System.out.println(obj.sumOfLeftLeaves(root));
    }
}