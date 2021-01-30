package com.zy.heap;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class LeastNumbers {

    @Test
    public void test() {
//        int[] arr = {3, 0, 9, 2, 1, 4, 6, 8, 5};
//        int k = 3;
        int[] arr = {0, 1, 1, 1, 4, 5, 3, 7, 7, 8, 10, 2, 7, 8, 0, 5, 2, 16, 12, 1, 19, 15, 5, 18, 2, 2, 22, 15, 8, 22, 17, 6, 22, 6, 22, 26, 32, 8, 10, 11, 2, 26, 9, 12, 9, 7, 28, 33, 20, 7, 2, 17, 44, 3, 52, 27, 2, 23, 19, 56, 56, 58, 36, 31, 1, 19, 19, 6, 65, 49, 27, 63, 29, 1, 69, 47, 56, 61, 40, 43, 10, 71, 60, 66, 42, 44, 10, 12, 83, 69, 73, 2, 65, 93, 92, 47, 35, 39, 13, 75};
        int k = 75;
        int[] result = getLeastNumbers(arr, k); // [0,0,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,4,5,5,5,6,6,6,7,7,7,7,7,8,8,8,8,9,9,10,10,10,10,11,12,12,12,13,15,15,16,17,17,18,19,19,19,19,20,22,22,22,22,23,26,26,27,27,28,29,31,32,33,35,36,39,40,42]
        print(result);
    }

    public static void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(", ");
        }
        System.out.println(sb.toString());
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (k < 1) {
            return result;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.remove();
                queue.add(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] result = new int[k];
        if (k < 1) {
            return result;
        }
        // build heap, shift up
        int last_node = k - 1;
        int last_parent = (last_node - 1) / 2;
        for (int i = last_parent; i >= 0; i--) {
            heapify(arr, k, i);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                heapify(arr, k, 0);
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }

        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }
        if (i != max) {
            swap(tree, i, max);
            heapify(tree, n, max);
        }
    }

    public void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
