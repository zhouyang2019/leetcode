package com.zy.str;

import org.junit.Test;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * <p>
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class ReverseLeftWords {

    @Test
    public void test() {
        String s = "abcdefg";
        int n = 1;
        System.out.println(reverseLeftWords(s, n));
        System.out.println(reverseLeftWords2(s, n));
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return null;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = new char[s.length()];
        for (int i = 0; i < s.length() - n; i++) {
            chars2[i] = chars1[i + n];
        }
        for (int i = 0; i < n; i++) {
            chars2[s.length() - n + i] = chars1[i];
        }
        return new String(chars2, 0, s.length());
    }

    public String reverseLeftWords2(String s, int n) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);
        return new String(chars, 0, s.length());
    }

    /**
     * 左闭右闭
     */
    public void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[r];
            chars[r--] = chars[l];
            chars[l++] = tmp;
        }
    }

}
