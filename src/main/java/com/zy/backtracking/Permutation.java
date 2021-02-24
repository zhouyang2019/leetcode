package com.zy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排列问题
 */
public class Permutation {

    /**
     * 46. Permutations
     * https://leetcode-cn.com/problems/permutations/
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        permuteBacktracking(nums, new boolean[nums.length], result, path);
        return result;
    }

    private void permuteBacktracking(int[] nums, boolean[] usedFlag, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!usedFlag[i]) {
                usedFlag[i] = true;
                path.add(nums[i]);
                permuteBacktracking(nums, usedFlag, result, path);
                usedFlag[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        Arrays.sort(nums);
//        List<Integer> unused = new ArrayList<>(nums.length);
//        for (int num : nums) {
//            unused.add(num);
//        }
//        permuteBacktracking(nums, unused, result, path);
//        return result;
//    }
//
//    private void permuteBacktracking(int[] nums, List<Integer> unused, List<List<Integer>> result, List<Integer> path) {
//        if (path.size() == nums.length) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < unused.size(); i++) {
//            Integer val = unused.remove(i);
//            path.add(val);
//            permuteBacktracking(nums, unused, result, path);
//            unused.add(i, val);
//            path.remove(val);
//        }
//    }


    /**
     * 47. Permutations II
     * https://leetcode-cn.com/problems/permutations-ii/
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        permuteUniqueBacktracking(nums, new boolean[nums.length], result, path);
        return result;
    }

    private void permuteUniqueBacktracking(int[] nums, boolean[] usedFlag, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && (nums[i] == nums[i - 1]) && (!usedFlag[i - 1])) {
                continue;
            }
            if (!usedFlag[i]) {
                usedFlag[i] = true; // 当前树枝已使用 nums[i]
                path.add(nums[i]);
                permuteUniqueBacktracking(nums, usedFlag, result, path);
                usedFlag[i] = false; // 当前树层已使用 nums[i]
                path.remove(path.size() - 1);
            }
        }
    }

}
