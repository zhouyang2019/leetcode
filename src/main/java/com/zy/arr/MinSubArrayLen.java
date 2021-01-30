package com.zy.arr;

import org.junit.Test;

import java.io.*;

/**
 * 209. 长度最小的子数组
 * <p>
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {

    @Test
    public void test() {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(s, nums));
    }

    @Test
    public void test2() {
        int s = 120331635;
        int[] nums;
        try (FileReader fileReader = new FileReader("/Users/zhouyang/IdeaProjects/leetcode/src/main/java/com/zy/arr/MinSubArrayLen_test_data.txt");
             BufferedReader bis = new BufferedReader(fileReader)) {
            String str = bis.readLine();
            String[] strings = str.split(",");
            nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            // 该方法有毒，循环累加操作，耗时指数级上升，甚至不如暴力法
//            System.out.println(minSubArrayLen(s, nums)); // 2327
            System.out.println(minSubArrayLen2(s, nums)); // 2327
            System.out.println(minSubArrayLen3(s, nums)); // 2327
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int minSubArrayLen3(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                int window = i - start + 1;
                result = Math.min(window, result);
                sum -= nums[start++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    int window = j - i + 1;
                    result = Math.min(result, window);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int windowSize = 1;
        while (windowSize <= nums.length) {
            int idx = slideWindow(nums, s, windowSize);
            if (idx >= 0) {
                return windowSize;
            }
            windowSize++;
        }
        return 0;
    }

    public int slideWindow(int[] nums, int s, int windowSize) {
        for (int i = 0; i <= nums.length - windowSize; i++) {
            int sum = 0;
            int j = i;
            for (; j < i + windowSize; j++) {
                sum += nums[j];
            }
            if (sum >= s) {
                System.out.println("bingo, 找到满足其和 ≥ s 的长度最小的 连续 子数组了，i:" + i + "; j:" + (i + windowSize - 1));
                print(nums, i, i + windowSize - 1);
                return i;
            }
        }
        return -1;
    }

    public void print(int[] nums, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (; i <= j; i++) {
            sb.append(nums[i]).append(", ");
        }
        System.out.println(sb.toString());
    }

}
