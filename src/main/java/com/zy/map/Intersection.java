package com.zy.map;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.zy.heap.Heap.print;

/**
 * 349. 两个数组的交集
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Intersection {

    @Test
    public void test() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        print(intersection(nums1, nums2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1 || nums2 == null || nums2.length < 1) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }

        int[] result = new int[intersection.size()];
        int idx = 0;
        for (Integer i : intersection) {
            result[idx++] = i;
        }

        return result;
    }

}
