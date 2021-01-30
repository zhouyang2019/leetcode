package com.zy.arr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 15. 三数之和
 * <p>
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    @Test
    public void test() {
        int[] nums = {2,7,11,15};
        int target = 13;
        print(twoSum(nums, target));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int matchVal = target - nums[i];
            if (null != map.get(matchVal)) {
                return new int[]{i, map.get(matchVal)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("不存在");
    }

    class Tuple {

        int x;
        int y;
        int sum;
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
            this.sum = x + y;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    public static void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(", ");
        }
        System.out.println(sb.toString());
    }

}
