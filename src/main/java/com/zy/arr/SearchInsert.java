package com.zy.arr;

import org.junit.Test;

/**
 * 35. 搜索插入位置
 * <p>
 * https://leetcode-cn.com/problems/search-insert-position/
 */
public class SearchInsert {

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsert2(nums, target));
        System.out.println(searchInsert3(nums, target));
        System.out.println(biSearch(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                continue;
            } else {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 只要给出的数组是有序数组，都可以想一想是否可以用二分法
     * <p>
     * 以下的代码中定义 target 是在一个在左闭右闭的区间里[left, right]
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {  // 当left==right，区间[left, right]依然有效
            int mid = left + ((right - left) >> 1); // 避免溢出
            if (nums[mid] > target) {
                right = mid - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

    /**
     * 以下的代码中定义 target 是在一个在左闭右开的区间里[left, right)
     */
    public int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

    public int biSearch(int[] nums, int val) {
        return biSearchInternal(nums, 0, nums.length, val);
    }

    public int biSearchInternal(int[] nums, int l, int r, int val) {
        if (l > r) {
            return r + 1;
        }
        int mid = l + ((r - l) / 2);
        if (nums[mid] > val) {
            return biSearchInternal(nums, l, mid - 1, val);
        } else if (nums[mid] < val) {
            return biSearchInternal(nums, mid + 1, r, val);
        } else {
            return mid;
        }
    }
}
