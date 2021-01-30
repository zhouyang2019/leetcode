package com.zy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://blog.csdn.net/My_Jobs/article/details/43451187
 */
public class TreeTraverse {

    public static List<Integer> preOrderTraverse1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            result.addAll(preOrderTraverse1(root.left));
            result.addAll(preOrderTraverse1(root.right));
        }
        return result;
    }

    public static List<Integer> preOrderTraverse2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                result.add(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop().right;
            }
        }
        return result;
    }

    public static List<Integer> inOrderTraverse1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inOrderTraverse1(root.left));
            result.add(root.val);
            result.addAll(inOrderTraverse1(root.right));
        }
        return result;
    }

    public static List<Integer> inOrderTraverse2(TreeNode root) {
        // 通常情况下，不推荐使用Vector以及其子类Stack
//        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                pNode = node.right;
            }
        }
        return result;
    }

    public static List<Integer> postOrderTraverse1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(postOrderTraverse1(root.left));
            result.addAll(postOrderTraverse1(root.right));
            result.add(root.val);
        }
        return result;
    }

    public static List<Integer> postOrderTraverse2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop().right;
            }

            if (pNode != null) {
                stack.push(pNode);
                TreeNode left = pNode.left;
                TreeNode right = pNode.right;
                pNode = left;
                if (right != null) {
                    stack.push(right);
                    pNode = right;
                }
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                pNode = node.right;
            }
        }
        return result;
    }

    /**
     * 层次遍历
     */
    public static List<Integer> levelTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }

        return result;
    }

    /**
     * 深度优先遍历
     */
    public static List<Integer> depthOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }

        return result;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int minDepth(TreeNode root) {
        return root == null ? 0 : Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    /**
     * 十进制转二十六进制
     */
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if (c == 0)
                c = 27;
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }
        return sb.toString();
    }

}
