package com.zy.backtracking;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NQueensTest {

    NQueens obj = new NQueens();

    @Test
    public void solveNQueens() {
        System.out.println(obj.solveNQueens(4));
        System.out.println(obj.solveNQueens(5));
    }

    @Test
    public void detectAttack() {
        System.out.println(obj.detectAttack(Arrays.asList(1,3,0,2)));
        System.out.println(obj.detectAttack(Arrays.asList(2,0,3,1)));
        System.out.println(obj.detectAttack(Arrays.asList(1,3,0,4,2)));
    }
}