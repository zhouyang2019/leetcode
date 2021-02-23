package com.zy.backtracking;

import org.junit.Test;

public class SubSetTest {

    SubSet obj = new SubSet();

    @Test
    public void subsets() {
        System.out.println(obj.subsets(new int[]{1,2,3}));
        System.out.println(obj.subsets(new int[]{0}));
    }

    @Test
    public void subsetsWithDup() {
        System.out.println(obj.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(obj.subsetsWithDup(new int[]{0}));
        System.out.println(obj.subsetsWithDup(new int[]{4,4,4,1,4}));
        System.out.println(obj.subsetsWithDup(new int[]{4,2,3,1,4}));
    }

    @Test
    public void findSubsequences() {
        System.out.println(obj.findSubsequences(new int[]{6,4,7,7}));
    }
}