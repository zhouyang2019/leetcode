package com.zy.heap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * <p>
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        print(topKFrequent(nums, k));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer v = map.get(num);
            if (v == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++v);
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.count - b.count);
        int idx = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (idx < k) {
                queue.add(new Node(e.getKey(), e.getValue()));
            } else {
                Node node = queue.peek();
                if (e.getValue() > node.count) {
                    queue.poll();
                    queue.add(new Node(e.getKey(), e.getValue()));
                }
            }
            ++idx;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll().num;
        }
        return result;
    }

    class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(", ");
        }
        System.out.println(sb.toString());
    }

}
