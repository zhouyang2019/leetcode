package com.zy.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceTreeTest {

    BalanceTree bt = new BalanceTree();
    TreeNode root = TreeTraverseTest.root;

    @Test
    public void test_isBalanced() {
        System.out.println(bt.isBalanced(root));
        System.out.println(bt.isBalanced2(root));
    }
}