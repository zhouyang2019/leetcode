package com.zy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. Find Mode in Binary Search Tree
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class BSTMode2 {

    private int base;
    private int cnt;
    private int maxCnt;
    private List<Integer> result;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        searchBST(root);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void searchBST(TreeNode root) {
        if (root == null) {
            return;
        }

        searchBST(root.left);

        if (root.val == base) {
            ++cnt;
        } else {
            base = root.val;
            cnt = 1;
        }

        if (cnt > maxCnt) {
            maxCnt = cnt;
            result = new ArrayList<Integer>() {{
                add(base);
            }};
        } else if (cnt == maxCnt) {
            result.add(base);
        }

        searchBST(root.right);

    }


}
