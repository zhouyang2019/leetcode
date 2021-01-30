package com.zy.str;

import org.junit.Test;

/**
 * 151. 翻转字符串里的单词
 * <p>
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWords {

    @Test
    public void test() {
//        String s = " the sky is blue ";
//        String s = " the sky is blue";
//        String s = "the sky is blue ";
//        String s = "the sky is blue";
//        String s = "a ";
//        String s = " a";
//        String s = " ";
//        String s = "  ";
//        String s = "a good   example";
        String s = "  hello world  ";
        System.out.println(s);
        System.out.println(reverseWords3(s));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public String reverseWords(String s) {
        if (s == null || (s.length() < 1)) {
            return s;
        }
        if (s.length() == 1) {
            if (s == " ") {
                return "";
            } else {
                return s;
            }
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = new char[s.length() + 1];
        int l1, r1;
        int l2 = 0;

        for (int i = chars1.length - 1; i >= 0; i--) {
            while (i >= 0) {
                if (chars1[i] == ' ') {
                    i--;
                } else {
                    break;
                }
            }
            r1 = i;
            if (r1 < 0) {
                break;
            }

            while (i >= 0) {
                if (chars1[i] != ' ') {
                    i--;
                } else {
                    break;
                }
            }
            l1 = i + 1;

            int offset = r1 - l1 + 1;
            chars2[l2++] = ' ';
            moveWords(chars1, l1, chars2, l2, offset);
            l2 += offset;
        }
        return new String(chars2, 1, l2 - 1);
    }

    /**
     * 左闭右闭区间
     */
    public void moveWords(char[] chars1, int l1, char[] chars2, int l2, int offset) {
        for (int i = 0; i < offset; i++) {
            chars2[l2 + i] = chars1[l1 + i];
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public String reverseWords3(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int fast = 0;
        int slow = 0;
        boolean firstWord = true;
        boolean paddingSpace = false;
        while (fast < chars.length) {
            if (chars[fast] == ' ') {
                fast++;
                continue;
            }
            if (fast > 0 && (chars[fast] != ' ') && chars[fast - 1] == ' ') {
                paddingSpace = true;
            } else {
                paddingSpace = false;
            }
            if (firstWord) {
                firstWord = false;
            } else if (paddingSpace) {
                chars[slow++] = ' ';
            }

            chars[slow++] = chars[fast++];
        }

        reverseChar(chars, 0, slow - 1);

        int l = 0;
        int r = 0;
        while (r < slow) {
            if (chars[r] == ' ') {
                reverseChar(chars, l, r - 1);
                l = ++r;
            } else {
                r++;
            }
        }
        reverseChar(chars, l, slow - 1);

        return new String(chars, 0, slow);
    }

    public String reverseWords2(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        for (int i = 0; i < chars.length; i++) {
            while (i < chars.length) {
                if (chars[i] == ' ') {
                    i++;
                } else {
                    l = i;
                    break;
                }
            }

            while (i < chars.length) {
                if (chars[i] != ' ') {
                    i++;
                } else {
                    break;
                }
            }
            reverseChar(chars, l, i - 1);
        }
        return new String(chars);
    }

    /**
     * 左闭右闭区间
     */
    public void reverseChar(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }

}
