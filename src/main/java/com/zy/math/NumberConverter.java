package com.zy.math;

public class NumberConverter {

    /**
     * 十进制转二十六进制
     * 168. Excel表列名称   https://leetcode-cn.com/problems/excel-sheet-column-title/
     *
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 示例 2:
     *
     * 输入: 28
     * 输出: "AB"
     */
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int c = n % 26;
            if (c == 0)
                c = 27;
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }
        return sb.toString();
    }

}
