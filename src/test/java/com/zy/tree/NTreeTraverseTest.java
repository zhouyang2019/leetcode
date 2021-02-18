package com.zy.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class NTreeTraverseTest {

    NTreeTraverse traverse = new NTreeTraverse();
    NTreeNode root = NTreeNode.createNTreeNode(new Integer[]{1,3,2,4,5,6}, 3);

    @Test
    public void test_preorder() {
        System.out.println(traverse.preorder(root));
        System.out.println(traverse.preorder2(root));
    }

    @Test
    public void test_postOrder() {
        System.out.println(traverse.postOrder(root));
    }

    @Test
    public void test_levelOrder() {
        System.out.println(traverse.levelOrder(root));
    }
}