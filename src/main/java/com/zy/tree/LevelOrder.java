package com.zy.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 102. 二叉树的层序遍历
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {

    @Test
    public void test() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        for (List<Integer> list : levelOrder(root)) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 每一层的节点个数
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }

        return result;
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(levelOrder2(root));
        System.out.println(levelOrder3(root));
    }

    /**
     * 递归
     */
    public List<Integer> levelOrder2(TreeNode root) {
        LinkedList<Integer> queue = new LinkedList<>();
        levelTraverse(root, queue);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
    public void levelTraverse(TreeNode node, LinkedList<Integer> queue) {
        if (node != null) { // 递归终止条件
            queue.offer(node.val);
            levelTraverse(node.left, queue);
            levelTraverse(node.right, queue);
        }
    }

    /**
     * 迭代
     */
    public List<Integer> levelOrder3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) { // 迭代终止条件
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return result;
    }

}
