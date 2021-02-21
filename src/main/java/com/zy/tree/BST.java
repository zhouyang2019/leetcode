package com.zy.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Binary Search Tree 二叉树
 *
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BST {

//    @Test
//    public void test() {
//        TreeNode treeNode = TreeNode.createTreeNode(new Integer[]{2147483647});
////        TreeNode treeNode = TreeNode.createTreeNode(new Integer[]{2,1,3});
////        TreeNode treeNode = TreeNode.createTreeNode(new Integer[]{5, 1, 4, null, null, 3, 6});
//        System.out.println(isValidBST(treeNode));
//        System.out.println(isValidBST2(treeNode));
//    }

    /**
     * 递归
     */
    public boolean isValidBST(TreeNode root) {
//        return isValidBSTInterval(root, Integer.MIN_VALUE, Integer.MAX_VALUE); // 当root.val=Integer.MAX_VALUE时会出错
        return isValidBSTInterval(root, null, null);
    }

    public boolean isValidBSTInterval(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && (node.val <= min)) {
            return false;
        }
        if (max != null && (node.val >= max)) {
            return false;
        }

        if (!isValidBSTInterval(node.left, min, node.val)) {
            return false;
        }
        if (!isValidBSTInterval(node.right, node.val, max)) {
            return false;
        }

        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = inOrderTraverse(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inOrderTraverse(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.addAll(inOrderTraverse(node.left));
            result.add(node.val);
            result.addAll(inOrderTraverse(node.right));
        }
        return result;
    }

    /**
     * 530. Minimum Absolute Difference in BST
     * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = inOrderTraverse(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            int v = Math.abs(list.get(i + 1) - list.get(i));
            min = Math.min(min, v);
        }
        return min;
    }


    /**
     * 501. Find Mode in Binary Search Tree
     * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
     */
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        // key是root.val，value是count
        Map<Integer, Integer> map = new HashMap<>();
        inTraverse(root, map);

        List<Integer> maxKeyList = new ArrayList<Integer>() {{
            add(0);
        }};
        int maxVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxKeyList = new ArrayList<Integer>() {{
                    add(entry.getKey());
                }};
            } else if (entry.getValue() == maxVal) {
                maxKeyList.add(entry.getKey());
            }
        }
        return maxKeyList.stream().mapToInt(i -> i).toArray();
    }

    public void inTraverse(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            Integer cnt = map.get(root.val);
            if (cnt == null) {
                map.put(root.val, 1);
            } else {
                map.put(root.val, ++cnt);
            }
            inTraverse(root.left, map);
            inTraverse(root.right, map);
        }
    }

}
