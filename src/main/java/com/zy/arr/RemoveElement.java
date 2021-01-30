package com.zy.arr;

import org.junit.Test;

/**
 * 27. 移除元素
 *
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    @Test
    public void test() {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    /**
     * 快慢指针法
     */
    public int removeElement(int[] nums, int val) {
        int slowIdx = 0;
        for (int fastIdx = 0; fastIdx < nums.length; fastIdx++) {
            if (nums[fastIdx] != val) {
                nums[slowIdx++] = nums[fastIdx];
            }
        }
        return slowIdx;
    }

}
