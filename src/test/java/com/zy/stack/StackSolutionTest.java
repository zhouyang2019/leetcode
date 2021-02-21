package com.zy.stack;

import org.junit.Test;

public class StackSolutionTest {

    StackSolution obj = new StackSolution();

    @Test
    public void test_isValid() {
        System.out.println(new StackSolution().isValid("()"));
        System.out.println(new StackSolution().isValid("{[]()}"));
        System.out.println(new StackSolution().isValid("[{[]()}")); // 多余的右括号
        System.out.println(new StackSolution().isValid("{[]()}]")); // 多余的左括号
        System.out.println(new StackSolution().isValid("{[]」()}")); // 不匹配的括号
    }

    @Test
    public void test_evalRPN() {
        System.out.println(obj.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(obj.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(obj.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}