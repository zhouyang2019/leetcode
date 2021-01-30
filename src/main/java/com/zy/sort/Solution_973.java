package com.zy.sort;

import java.util.Arrays;

public class Solution_973 {

    /**
     * 973. 最接近原点的 K 个点
     *
     * 输入：points = [[1,3],[-2,2]], K = 1
     * 输出：[[-2,2]]
     * 解释：
     * (1, 3) 和原点之间的距离为 sqrt(10)，
     * (-2, 2) 和原点之间的距离为 sqrt(8)，
     * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
     * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
     */
    //todo 待我撸到快排时再重写
    public int[][] stubidKClosest(int[][] points, int K) {
        if (K > points.length) {
            K = points.length;
        }
        // 算出每个点的距离
        int[] distance = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            // distance[i] = (int) Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            // 有溢出风险
            distance[i] = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
        }

        // 将前 K 小的点的数组下标存入 idx 数组
        int[] idx = new int[K];
        int p = 0;
        int[][] tmpMin = {{0, distance[0]}}; //每次循环最小值的 points 数组下标及距离值
        while (p < K) {
            for (int i = 0; i < points.length; i++) {
                if (distance[i] <= tmpMin[0][1]) {
                    tmpMin[0][0] = i;
                    tmpMin[0][1] = distance[i];
                }
            }
            idx[p++] = tmpMin[0][0];
            distance[tmpMin[0][0]] = Integer.MAX_VALUE;
            tmpMin[0][1] = Integer.MAX_VALUE;
        }

        // 将前 K 小的点拷贝到 rst 数组返回
        int[][] rst = new int[K][2];
        for (int i = 0; i < idx.length; i++) {
            rst[i][0] = points[idx[i]][0];
            rst[i][1] = points[idx[i]][1];
        }

        return rst;
    }

    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        work(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void work(int low, int hign, int k) {
        int l = low, r = hign;
        int tmp = distance(hign / 2 + low / 2);
        while (l < r) {
            if (distance(l) <= tmp) {
                l++;
            } else {
                if (distance(r) >= tmp) {
                    r--;
                } else {
                    // swap
                    int tx = points[r][0], ty = points[r][1];
                    points[r][0] = points[l][0];
                    points[r][1] = points[l][1];
                    points[l][0] = tx;
                    points[l][1] = ty;
                    l++;
                    r--;
                }
            }
        }
        if (l > k) {
            work(low, l, k);
        } else if (l < k) {
            work(l + 1, hign, k - l);
        } else {
            return;
        }

    }

    private int distance(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

}
