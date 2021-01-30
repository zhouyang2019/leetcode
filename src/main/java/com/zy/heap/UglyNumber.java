package com.zy.heap;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 313. 超级丑数
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * <p>
 * https://leetcode-cn.com/problems/super-ugly-number/
 * <p>
 * 示例：
 * 输入: n = 12, primes = [2,7,13,19]
 * 输出: 32
 * 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 */
public class UglyNumber {

    @Test
    public void test() {
        int n = 100000;
        int[] primes = {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251};
//        System.out.println(nthSuperUglyNumber(n, primes)); // 1092889481
        System.out.println(nthSuperUglyNumber2(n, primes)); // 1092889481
    }

    @Test
    public void test2() {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber2(n, primes));
    }

    public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < primes.length; i++) {
            // item[0]:丑数, item[1]:丑数索引, item[2]:质因子索引
            int[] item = new int[]{primes[i], 0, i};
            queue.add(item);
        }
        for (int i = 1; i < n; i++) {
            int[] item = queue.poll();
            ugly[i] = item[0];
            // 新的丑数 == 老的丑数 * 质因子
            int[] newItem = new int[]{ugly[++item[1]] * primes[item[2]], item[1], item[2]};
            queue.add(newItem);
            if (ugly[i] == ugly[i - 1]) {
                i--;
            }
        }
        return ugly[n - 1];
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int idx = 1;
        int uglyNum = 1;
        while (uglyNum < n) {
            ++idx;
            if (isUgly(idx, primes)) {
                ++uglyNum;
            }
        }
        return idx;
    }

    private boolean isUgly(int n, int[] primes) {
        for (int i = 0; i < primes.length; i++) {
            while (n % primes[i] == 0) {
                n = n / primes[i];
            }
        }
        return n == 1;
    }

}
