package com.zy.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 202. 快乐数
 * <p>
 * https://leetcode-cn.com/problems/happy-number/
 */
public class HappyNumber {

    @Test
    public void test() {
//        System.out.println(compute(0));
//        System.out.println(compute(4));
//        System.out.println(compute(12));
//        System.out.println(compute(123));
//        System.out.println(compute(12303));
        System.out.println(isHappy2(19));
        System.out.println(isHappy2(23));
        System.out.println(isHappy2(4));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int tmp = n;
        while (tmp != 1) {
            tmp = compute(tmp);
            if (set.contains(tmp)) {
                return false;
            }
            set.add(tmp);
        }

        return true;
    }

    public int compute(int n) {
        List<Integer> list = new ArrayList<>();
        int i = n;
        while (i != 0) {
            list.add(i % 10);
            i = i / 10;
        }
        int result = 0;
        for (int i1 = 0; i1 < list.size(); i1++) {
            result += list.get(i1) * list.get(i1);
        }
        return result;
    }

    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = getNext(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public int getNext(int n) {
        int result = 0;
        while (n != 0) {
            int i = n % 10;
            result += i * i;
            n /= 10;
        }
        return result;
    }

}
