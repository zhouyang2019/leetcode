package com.zy.backtracking;

import org.junit.Test;

public class PermutationTest {

    Permutation obj = new Permutation();

    @Test
    public void permute() {
        System.out.println(obj.permute(new int[]{1,2,3}));
    }

    @Test
    public void permuteUnique() {
        System.out.println(obj.permuteUnique(new int[]{1,2,3}));
        System.out.println(obj.permuteUnique(new int[]{1,1,2}));
        System.out.println(obj.permuteUnique(new int[]{2,2,1,1}));
    }
}