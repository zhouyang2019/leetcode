package com.zy.stack;

import java.util.LinkedList;

public class Solution {

    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public int calPoints(String[] ops) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                // 表示本轮获得的得分是前两轮有效 回合得分的总和。
                case "+":
                    int last = stack.pop();
                    int last2 = stack.peek();
                    stack.push(last);
                    stack.push(last + last2);
                    break;
                // 表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
                case "C":
                    stack.pop();
                    break;
                // 表示本轮获得的得分是前一轮有效 回合得分的两倍。
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                default:
                    stack.push(Integer.valueOf(ops[i]));
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}
