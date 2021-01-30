package com.zy.str;

import org.junit.Test;

import static com.zy.heap.Heap.print;

/**
 * 28. 实现 strStr()
 *
 * 示例 1:
 *
 * 输入: haystack = "aabaabaaf", needle = "aabaaf"
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {

    @Test
    public void test() {
        String haystack = "aabaabaaf";
//        String needle = "aabaaf";
//        String needle = "ab";
//        String needle = "";
        String needle = " ";
        System.out.println(haystack.indexOf(needle));
        System.out.println(strStr(haystack, needle));
    }

    @Test
    public void test2() {
        String haystack = "adcadcaddcadde";
        String needle = "adcadde";
        System.out.println(haystack.indexOf(needle));
        System.out.println(strStr(haystack, needle));
    }

    /**
     * KMP 算法，字符串匹配
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        int[] next = getNext(needle);
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int j = 0;
        for (int i = 0; i < chars1.length; i++) {
            while (j > 0 && (j < next.length) && (chars1[i] != chars2[j])) {
                j = next[j - 1];
            }

            // 完成匹配，返回 needle 字符串出现的第一个位置
            if ((j == chars2.length - 1) && (chars1[i] == chars2[j])) {
                return i + 1 - chars2.length;
            }

            if (j < next.length && (chars1[i] == chars2[j])) {
                j++;
            }
        }

        return -1;
    }

    @Test
    public void testGetNext() {
        print(getNext("aabaaf"));
        print(getNext("ll"));
        print(getNext("abca"));
        print(getNext("adcadde"));
        print(getNext("ababab"));
        print(getNext("abaababab"));
    }

    /**
     * 获取前缀表（最长相等前后缀）
     * @param needle "aabaaf"
     * @return [0,1,0,1,2,0]
     */
    public int[] getNext(String needle) {
        char[] chars = needle.toCharArray();
        int[] next = new int[needle.length()];
        int i = 1; // 后缀首位
        int j = 0; // 前缀末尾
        next[0] = 0;
        for (; i < needle.length(); i++) {
            while (j > 0 && (chars[j] != chars[i])) {
                j = next[j - 1];
            }
            if (chars[j] == chars[i]) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }

}
