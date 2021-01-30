package com.zy.heap;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallest {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 5;
        System.out.println(kthSmallest22(matrix, k));
    }

    /**
     * 大顶堆查找第 K 小的元素
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (queue.size() < k) {
                    queue.add(matrix[i][j]);
                } else {
                    if (matrix[i][j] < queue.peek()) {
                        queue.remove();
                        queue.add(matrix[i][j]);
                    }
                }
            }
        }
        return queue.poll();
    }

    /**
     * 归并排序，从 n 个有序数组中找第 k 小的数
     * n 个数组归并查找第 k 小的数，使用小顶堆
     * <p>
     * 时间复杂度：k * logN
     */
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.add(new Node(matrix[i][0], i, 0));
        }
        Node node = new Node(matrix[0][0], 0, 0);
        while (k > 0) {
            node = queue.poll();
            if (node.dim2 < n - 1) {
                Node next = new Node(matrix[node.dim1][node.dim2 + 1], node.dim1, node.dim2 + 1);
                queue.add(next);
            }
            k--;
        }
        return node.val;
    }

    public int kthSmallest22(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{matrix[i][0], i, 0});
        }
        int result = matrix[0][0];
        while (k > 0) {
            int[] cur = queue.poll();
            result = cur[0];
            if (cur[2] < n - 1) {
                int[] next = new int[]{matrix[cur[1]][cur[2] + 1], cur[1], cur[2] + 1};
                queue.add(next);
            }
            k--;
        }
        return result;
    }

    class Node {
        private int val;
        private int dim1;
        private int dim2;

        public Node(int val, int dim1, int dim2) {
            this.val = val;
            this.dim1 = dim1;
            this.dim2 = dim2;
        }
    }

    /**
     * 二分查找
     * 时间复杂度：N
     */
    // TODO
}
