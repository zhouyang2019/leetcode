package com.zy.stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class StackSolution {

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


    /**
     * 20. Valid Parentheses
     * https://leetcode-cn.com/problems/valid-parentheses/
     */
    public boolean isValid(String s) {
        //  不纠结空间时间复杂度了,生产中这么写最好理解最好实现，如果该操作不是极高频操作，性能影响不大
        // while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
        //     s = s.replaceAll("\\(\\)", "").replaceAll("\\[\\]", "").replaceAll("\\{\\}", "");
        // }

        // return "".equals(s) ? true : false;

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || s.charAt(i) != stack.peekFirst()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 1047. Remove All Adjacent Duplicates In String
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     */
    public String removeDuplicates(String S) {
        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if ((!queue.isEmpty()) && S.charAt(i) == queue.peekFirst()) {
                queue.pop();
            } else {
                queue.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pollLast());
        }
        return sb.toString();
    }

    /**
     * 150. Evaluate Reverse Polish Notation
     * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
     */
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                queue.push(queue.pop() + queue.pop());
            } else if ("-".equals(tokens[i])) {
                queue.push(-(queue.pop() - queue.pop()));
            } else if ("*".equals(tokens[i])) {
                queue.push(queue.pop() * queue.pop());
            } else if ("/".equals(tokens[i])) {
                Integer i1 = queue.pop();
                Integer i2 = queue.pop();
                queue.push(i2 / i1);
            } else {
                queue.push(Integer.valueOf(tokens[i]));
            }
        }
        return queue.pop();
    }

}
