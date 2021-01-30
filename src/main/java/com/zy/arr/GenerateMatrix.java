package com.zy.arr;

import org.junit.Test;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
public class GenerateMatrix {

    @Test
    public void test() {
        int[][] result = generateMatrix(6);
        for (int[] ints : result) {
            print(ints);
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0;
        int startY = 0; // 每次循环的起始点坐标
        int loopNum = n / 2; // 循环次数，基1
        int curNum = 1; // 填充到矩阵中的值

        for (int i = 1; i <= loopNum; i++) {
            // 从左到右填充，左开右闭区间
            for (int i1 = startY; i1 < n - i; i1++) {
                result[startX][i1] = curNum++;
            }
            // 从上到下填充，左开右闭区间
            for (int i2 = startX; i2 < n - i; i2++) {
                result[i2][n - startY - 1] = curNum++;
            }
            // 从右到左填充，左开右闭区间
            for (int i3 = n - i; i3 > startY; i3--) {
                result[n - i][i3] = curNum++;
            }
            // 从下到上填充，左开右闭区间
            for (int i4 = n - i; i4 > startX; i4--) {
                result[i4][startY] = curNum++;
            }
            startX++;
            startY++;
        }

        if ((n & 1) == 1) {
            int mid = n / 2; // 若 n 为基数，则有一个中心点不在循环里，需要单独处理
            result[mid][mid] = curNum;
        }

        return result;
    }

    public void print(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(", ");
        }
        System.out.println(sb.toString());
    }

}
