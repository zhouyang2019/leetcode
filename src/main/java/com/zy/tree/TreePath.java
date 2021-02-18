package com.zy.tree;


import java.util.*;

public class TreePath {

    /**
     * 257. Binary Tree Paths   https://leetcode-cn.com/problems/binary-tree-paths/
     *
     * Input:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * Output: ["1->2->5", "1->3"]
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        LinkedList<Integer> paths = new LinkedList<>();
        if (root == null) {
            return result;
        }

        traversal(root, paths, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> result) {
        paths.add(root.val);
        if (root.left == null && (root.right == null)) {
            StringBuilder sb = new StringBuilder();
            int size = paths.size();
            for (int i = 0; i < size; i++) {
                sb.append(paths.get(i)).append("->");
            }
            String path = sb.toString();
            result.add(path.substring(0, path.length() - 2));
            return;
        }
        if (root.left != null) {
            traversal(root.left, paths, result);
            paths.remove(paths.size() - 1); // 回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, result);
            paths.remove(paths.size() - 1); // 回溯
        }
    }

    /**
     * 112. Path Sum    https://leetcode-cn.com/problems/path-sum/
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        List<Integer> paths = new ArrayList<>();
        return traversePath(root, paths, targetSum);
    }
    public boolean traversePath(TreeNode root, List<Integer> paths, int targetSum) {
        paths.add(root.val);
        if (root.left == null && (root.right == null)) {
            int sum = 0;
            for (int i = 0; i < paths.size(); i++) {
                sum += paths.get(i);
            }
            if (sum == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        if (root.left != null) {
            if (traversePath(root.left, paths, targetSum)) {
                return true;
            }
            paths.remove(paths.size() - 1); // 回溯
        }

        if (root.right != null) {
            if (traversePath(root.right, paths, targetSum)) {
                return true;
            }
            paths.remove(paths.size() - 1); // 回溯
        }

        return false;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && (root.right == null) && (root.val == targetSum)) {
            return true;
        }
        targetSum -= root.val;
        if (hasPathSum2(root.left, targetSum)) {
            return true;
        }
        if (hasPathSum2(root.right, targetSum)) {
            return true;
        }
        return false;
    }


}
