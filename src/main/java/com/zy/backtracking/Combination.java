package com.zy.backtracking;

import java.util.*;

/**
 * 组合问题
 */
public class Combination {

    /**
     * 77. Combinations
     * https://leetcode-cn.com/problems/combinations/
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combineBacktracking(n, k, 1, result, path);
        return result;
    }

    private void combineBacktracking(int n, int k, int startIdx, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == k) { // 终止条件
            result.add(new ArrayList<>(path)); // 保存结果
            return;
        }

//        while (startIdx <= n) { // 横向遍历
//        while (startIdx + k - path.size() - 1 <= n) { // 剪枝优化，注意这里要减1
//            path.add(startIdx); // 处理节点
//            combineBacktracking(n, k, ++startIdx, result, path); // 递归纵向遍历
//            path.remove(path.size() - 1); // 回溯删除最后一个元素
//        }
        for (int i = startIdx; i <= n - (k - path.size()) + 1; i++) { // 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
            path.add(i);
            combineBacktracking(n, k, i + 1, result, path);
            path.remove(path.size() - 1); // 回溯删除最后一个元素
        }
    }


    /**
     * 216. Combination Sum III
     * https://leetcode-cn.com/problems/combination-sum-iii/
     *
     * 在集合[1,9]中找到满足「和为 n 的 k 个数」条件的所有集合
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSum3Backtracking(n, k, 1, result, path, 0);
        return result;
    }

    private void combinationSum3Backtracking(int n, int k, int startIdx, List<List<Integer>> result, List<Integer> path, int pathSum) {
        if (pathSum > n) {
            return;
        }
        if (path.size() == k) { // 终止条件
            if (n == pathSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIdx; i <= 9 && (i + k - path.size() - 1 <= n); i++) {
            pathSum += i;
            path.add(i);
            combinationSum3Backtracking(n, k, i + 1, result, path, pathSum);
            pathSum -= i;
            path.remove(path.size() - 1);
        }
    }

    /**
     * 17. Letter Combinations of a Phone Number
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        List<Character> path = new ArrayList<>();
        letterCombinationsBacktracking(digits.toCharArray(), 0, result, path);
        return result;
    }

    Map<Character, char[]> map = new HashMap<Character, char[]>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};
    private void letterCombinationsBacktracking(char[] digits, int idx, List<String> result, List<Character> path) {
        if (idx == digits.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        char[] chars = map.get(digits[idx]);
        for (int i = 0; i < chars.length; i++) {
            path.add(chars[i]);
            letterCombinationsBacktracking(digits, idx + 1, result, path);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 39. Combination Sum
     * https://leetcode-cn.com/problems/combination-sum/
     *
     * candidates集合中的元素可以重复使用
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSumBacktracking(candidates, target, 0, result, path, 0);
        return result;
    }

    private void combinationSumBacktracking(int[] candidates, int target, int startIdx, List<List<Integer>> result, List<Integer> path, int pathSum) {
        if (pathSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (pathSum > target) {
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            pathSum += candidates[i];
            path.add(candidates[i]);
            combinationSumBacktracking(candidates, target, i, result, path, pathSum); // 注意: 不用i+1了，表示可以重复读取当前的数
            pathSum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    /**
     * 40. Combination Sum II
     * https://leetcode-cn.com/problems/combination-sum-ii/
     *
     * candidates数组中的元素不能重复使用
     * 注意：解集不能包含重复的组合。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Backtracking(candidates, target, 0, result, path, 0, new boolean[candidates.length]);
        return result;
    }

    private void combinationSum2Backtracking(int[] candidates, int target, int startIdx, List<List<Integer>> result, List<Integer> path, int pathSum, boolean[] used) {
        if (pathSum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (pathSum > target) {
            return;
        }

        for (int i = startIdx; i < candidates.length; i ++) {
            if (i > 0 && (candidates[i] == candidates[i - 1]) && (used[i - 1] == false)) {
                continue;
            }
            pathSum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            combinationSum2Backtracking(candidates, target, i + 1, result, path, pathSum, used);
            used[i] = false;
            pathSum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

}
