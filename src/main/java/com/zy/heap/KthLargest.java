package com.zy.heap;

/**
 * 703. 数据流中的第 K 大元素
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {

    private int k;
    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new int[k];
        int minLength = nums.length < this.nums.length ? nums.length : this.nums.length;
        for (int i = 0; i < minLength; i++) {
            this.nums[i] = nums[i];
        }
        for (int i = minLength; i < k; i++) {
            this.nums[i] = Integer.MIN_VALUE;
        }
        buildHeap();
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public void buildHeap() {
        int last_node = k - 1;
        int last_parent = (last_node - 1) / 2;
        for (int i = last_parent; i >= 0; i--) {
            heapify(nums, k, i);
        }
    }

    public void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int min = i;
        if (c1 < n && tree[c1] < tree[min]) {
            min = c1;
        }
        if (c2 < n && tree[c2] < tree[min]) {
            min = c2;
        }
        if (min != i) {
            swap(tree, i, min);
            heapify(tree, n, min);
        }
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int add(int val) {
        if (val > nums[0]) {
            nums[0] = val;
            heapify(nums, k, 0);
        }
        return nums[0];
    }

}
