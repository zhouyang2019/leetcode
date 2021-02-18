package com.zy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://blog.csdn.net/My_Jobs/article/details/43451187
 *
 * https://mp.weixin.qq.com/s/WKg0Ty1_3SZkztpHubZPRg
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
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pNode = stack.pop();
            result.add(pNode.val);
            if (pNode.right != null) {
                stack.push(pNode.right);
            }
            if (pNode.left != null) {
                stack.push(pNode.left);
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

    /**
     * 中序遍历：左中右
     * 要处理的元素与要访问的元素顺序不一致，所以与前序遍历的写法不同
     */
    public static List<Integer> inOrderTraverse2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode); // 将当前节点压栈
                pNode = pNode.left; // 当前节点移动到左节点
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

    /**
     * 后序遍历：左右中
     * 可以先通过「中右左」遍历，然后将遍历结果翻转即可得到「左右中」遍历结果
     */
    public static List<Integer> postOrderTraverse2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        int l = 0;
        int r = result.size() - 1;
        while (l < r) {
            Integer tmp = result.get(r);
            result.set(r--, result.get(l));
            result.set(l++, tmp);
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
     * 其实就是前序遍历
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

}
