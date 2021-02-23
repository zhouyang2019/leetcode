package com.zy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集问题
 */
public class SubSet {

    /**
     * 78. Subsets
     * https://leetcode-cn.com/problems/subsets/
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subsetsBacktracking(nums, 0, result, path);
        return result;
    }

    private void subsetsBacktracking(int[] nums, int startIdx, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsBacktracking(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }


    /**
     * 90. Subsets II
     * https://leetcode-cn.com/problems/subsets-ii/
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums); // 注意这里提前给 nums 排序
        subsetsWithDupBacktracking(nums, new boolean[nums.length], 0, result, path);
        return result;
    }

    private void subsetsWithDupBacktracking(int[] nums, boolean[] used, int startIdx, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<>(path));
        for (int i = startIdx; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树支candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            if (i > 0 && (nums[i] == nums[i - 1]) && (!used[i - 1])) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            subsetsWithDupBacktracking(nums, used, i + 1, result, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    /**
     * 491. Increasing Subsequences
     * https://leetcode-cn.com/problems/increasing-subsequences/
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findSubsequencesBacktracking(nums, 0, result, path);
        return result;
    }

    private void findSubsequencesBacktracking(int[] nums, int startIdx, List<List<Integer>> result, List<Integer> path) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        List<Integer> used = new ArrayList<>(); // 记录本树层使用过的数
        for (int i = startIdx; i < nums.length; i++) {
            // 当前节点比父节点小时，退出当前树枝
            if (path.size() > 0 && (nums[i] < path.get(path.size() - 1))) {
                continue;
            }
            // 当前节点在同一数层已经使用过时，退出当前树枝
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            findSubsequencesBacktracking(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

}
