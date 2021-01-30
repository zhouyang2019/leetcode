package com.zy.str;

import org.junit.Test;

/**
 * 剑指 Offer 05. 替换空格
 * <p>
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {

    @Test
    public void test() {
        String s = "We are happy.";
        System.out.println(s);
        System.out.println(replaceSpace(s));
    }

    public String replaceSpace(String s) {
        char[] chars = new char[s.length() * 3];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[idx++] = '%';
                chars[idx++] = '2';
                chars[idx++] = '0';
            } else {
                chars[idx++] = s.charAt(i);
            }
        }
        return new String(chars, 0, idx);
    }

}
