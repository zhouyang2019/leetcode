package com.zy.heap;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * <p>
 * https://leetcode-cn.com/problems/last-stone-weight/
 */
public class LastStone {

    @Test
    public void test1() {
        int[] a = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(a));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (a, b) -> b - a);
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }

        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int crashDust = Math.abs(first - second);
            if (crashDust > 0) {
                queue.add(crashDust);
            }
        }

        if (queue.size() > 0) {
            return queue.poll();
        }
        return 0;
    }
}
