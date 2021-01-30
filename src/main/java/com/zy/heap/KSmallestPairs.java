package com.zy.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 * <p>
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new ArrayList<>();
        }

        List<Pair> pairList = new ArrayList<>(nums1.length * nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pairList.add(new Pair(nums1[i], nums2[j]));
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        int threshold = Math.min(k, pairList.size());
        for (int i = 0; i < threshold; i++) {
            queue.add(pairList.get(i));
        }
        for (int i = threshold; i < pairList.size(); i++) {
            Pair p = pairList.get(i);
            Pair max = queue.peek();
            if (p.sum < max.sum) {
                queue.poll();
                queue.add(p);
            }
        }

        List<List<Integer>> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            Pair p = queue.poll();
            if (p != null) {
                ArrayList<Integer> list1s = new ArrayList(2);
                list1s.add(p.u);
                list1s.add(p.v);
                list.add(list1s);
            }
        }

        return list;
    }

    class Pair {
        int u;
        int v;
        int sum;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
            this.sum = u + v;
        }
    }
}
