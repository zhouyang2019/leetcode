package com.zy;

import java.util.List;

public class MathUtil {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        boolean endFlag = false;
        int i = 1;
        for (; i <= strs[0].length(); i++) {
            for (String str : strs) {
                if (! str.startsWith(strs[0].substring(0, i))) {
                    endFlag = true;
                }
            }
            if (endFlag) {
                break;
            }
        }
        return strs[0].substring(0, i - 1);
    }

    /**
     * 求两数最大公约数(辗转相除法)
     */
    public static int calCommonDivisor(int a, int b) {
        int dividend = Math.max(a, b);
        int divisor = Math.min(a, b);
        int r = dividend % divisor;
        while (r != 0) {
            dividend = divisor;
            divisor = r;
            r = dividend % divisor;
        }
        return divisor;
    }

    /**
     * 求多个数的最大公约数
     */
    public static int calCommonDivisor(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] = calCommonDivisor(a[i], a[i + 1]);
        }
        return a[a.length - 1];
    }

    public static int calCommonDivisor(List<Integer> list) {
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return calCommonDivisor(a);
    }

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String reverseStr = new StringBuffer(str).reverse().toString();
        if (str.equals(reverseStr)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(3000);
//        list.add(2000);
//        list.add(2500);
//        System.out.println(calCommonDivisor(list));

//        Integer i1 = 123;
//        Integer i2 = 2;
//        Integer rst1 = i1 / i2;
//        Double rst2 = (double) (i1 / i2);
//        Double rst3 = (double)i1 / (double)i2;
//        System.out.println(rst1);
//        System.out.println(rst2);
//        System.out.println(rst3);
//        System.out.println(Double.MAX_VALUE);

//        String[] strs = {"hello","heodf","he"};
//        System.out.println(longestCommonPrefix(strs));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
