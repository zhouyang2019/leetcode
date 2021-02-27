package com.zy.backtracking;

/**
 * 数独（九宫格游戏）
 */
public class Sudoku {

    /**
     * 37. Sudoku Solver
     * https://leetcode-cn.com/problems/sudoku-solver/
     */
    public void solveSudoku(char[][] board) {
        solveSudokuBacktracking(board);
    }

    // 找到一个符合的条件（就在树的叶子节点上）立刻就返回，所以用 boolean 返回值
    private boolean solveSudokuBacktracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                // board[i][j] 这个位置放 n 是否合适
                for (char n = '1'; n <= '9'; n++) {
                    if (attack(board, i, j, n)) {
                        continue;
                    }
                    board[i][j] = n;
                    if (solveSudokuBacktracking(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false; // 9个数都试完了，都不行，那么就返回false
            }
        }
        return true;
    }

    // 与 solveSudokuBacktracking 方法性能差异不大
    public boolean solveSudokuBacktracking2(char[][] board, int startX, int startY) {
        for (int i = startX; i < board.length; i++) {
            for (int j = startY; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                // board[i][j] 这个位置放 n 是否合适
                for (char n = '1'; n <= '9'; n++) {
                    if (attack(board, i, j, n)) {
                        continue;
                    }
                    board[i][j] = n;
                    if (solveSudokuBacktracking2(board, startX, startY)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false; // 9个数都试完了，都不行，那么就返回false
            }
        }
        return true;
    }

    private boolean attack(char[][] board, int x, int y, char n) {
        // x 这一行是否有冲突
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == n) {
                return true;
            }
        }
        // y 这一列是否有冲突
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == n) {
                return true;
            }
        }
        // board[x][y]所在九宫格是否有冲突
        int startX = x - (x % 3);
        int startY = y - (y % 3);
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == n) {
                    return true;
                }
            }
        }

        return false;
    }

}
