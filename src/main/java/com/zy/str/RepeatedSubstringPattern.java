package com.zy.str;

import org.junit.Test;

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 */
public class RepeatedSubstringPattern {

    @Test
    public void test() {
        System.out.println(repeatedSubstringPattern("abababab"));
        System.out.println(repeatedSubstringPattern("abcdabcdabcd"));
        System.out.println(repeatedSubstringPattern("abcd"));
        System.out.println(repeatedSubstringPattern(""));
        System.out.println(repeatedSubstringPattern("a"));
        System.out.println(repeatedSubstringPattern("aa"));
        System.out.println(repeatedSubstringPattern("aaa"));
        System.out.println(repeatedSubstringPattern("aaaabaababab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        int maxSameLength = getNext(s)[s.length() - 1];
        if (maxSameLength > 0 && (s.length() % (s.length() - maxSameLength) == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取前缀表
     */
    public int[] getNext(String s) {
        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();
        int j = 0; // 前缀尾
        int i = 1; // 后缀首
        result[0] = 0;
        for (; i < s.length(); i++) {
            while (j > 0 && (chars[i] != chars[j])) {
                j = result[j - 1]; // j 回退
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            result[i] = j;
        }
        return result;
    }
}
