package com.zy.backtracking;

import org.junit.Test;

public class CombinationTest {

    Combination obj = new Combination();

    @Test
    public void combine() {
        System.out.println(obj.combine(4, 1));
        System.out.println(obj.combine(4, 2));
        System.out.println(obj.combine(1, 1));
        System.out.println(obj.combine(4, 4));
    }

    @Test
    public void combinationSum3() {
        System.out.println(obj.combinationSum3(3, 7));
        System.out.println(obj.combinationSum3(3, 9));
        System.out.println(obj.combinationSum3(4, 1));
        System.out.println(obj.combinationSum3(3, 2));
        System.out.println(obj.combinationSum3(9, 45));
        System.out.println(obj.combinationSum3(2, 18));
    }

    @Test
    public void letterCombinations() {
        System.out.println(obj.letterCombinations("23"));
        System.out.println(obj.letterCombinations(""));
        System.out.println(obj.letterCombinations("2"));
        System.out.println(obj.letterCombinations("7")); // 注意按键7和9有四个字母
    }

    @Test
    public void combinationSum() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
    }

    @Test
    public void test_combinationSum2() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(obj.combinationSum2(candidates, target));
    }
    @Test
    public void test_combinationSum2_2() {
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        System.out.println(obj.combinationSum2(candidates, target));
    }
}