package com.zy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NTreeTraverse {

    public List<Integer> preorder(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            List<NTreeNode> childrens = root.children;
            if (childrens != null) {
                for (int i = 0; i < childrens.size(); i++) {
                    result.addAll(preorder(childrens.get(i)));
                }
            }
        }
        return result;
    }

    public List<Integer> preorder2(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<NTreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NTreeNode pNode = stack.pop();
            result.add(pNode.val);
            List<NTreeNode> children = pNode.children;
            if (children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return result;
    }

    public List<Integer> postOrder(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            List<NTreeNode> children = root.children;
            if (children != null) {
                for (int i = 0; i < children.size(); i++) {
                    result.addAll(postOrder(children.get(i)));
                }
            }
            result.add(root.val);
        }
        return result;
    }

    public List<Integer> levelOrder(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            NTreeNode node = queue.poll();
            result.add(node.val);
            List<NTreeNode> children = node.children;
            if (children != null) {
                for (int i = 0; i < children.size(); i++) {
                    queue.offer(children.get(i));
                }
            }
        }
        return result;
    }
}
