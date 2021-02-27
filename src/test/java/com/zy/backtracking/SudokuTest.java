package com.zy.backtracking;

import org.junit.Test;

public class SudokuTest {

    Sudoku obj = new Sudoku();

    @Test
    public void solveSudoku() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        obj.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }

        System.out.println("============================================================================");
        obj.solveSudokuBacktracking2(board, 0, 0);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }
}