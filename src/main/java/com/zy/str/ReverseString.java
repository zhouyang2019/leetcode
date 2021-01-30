package com.zy.str;

import org.junit.Test;

/**
 * 344. 反转字符串
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class ReverseString {

    @Test
    public void test() {
        char[] s = {'h', 'e', 'l', 'l', 'o', '!'};
        System.out.println(s);
        reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            l++;
            r--;
        }
    }

    @Test
    public void testReverseStr() {
        String s = "abcdefg";
//        String s = "a";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            reverseStr(chars, i, k);
            i += 2 * k;
        }
        return new String(chars);
    }

    /**
     * 反转s, 左闭右开区间[start, n)
     */
    public void reverseStr(char[] s, int start, int n) {
        int l = start;
        int r = start + n - 1;
        if (r > s.length - 1) {
            r = s.length - 1;
        }
        while (l < r) {
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            l++;
            r--;
        }
    }

}
