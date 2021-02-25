package com.zy.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    /**
     * 51. N-Queens
     * https://leetcode-cn.com/problems/n-queens/
     */
    public List<List<String>> solveNQueens(int n) {
        List<Integer> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        solveNQueensBacktracking(n, path, result);
        return result;
    }

    private void solveNQueensBacktracking(int n, List<Integer> path, List<List<String>> result) {
        if (detectAttack(path)) {
            return;
        }
        if (n == path.size()) {
            result.add(build(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);
            solveNQueensBacktracking(n, path, result);
            path.remove(path.size() - 1);
        }
    }

    private List<String> build(List<Integer> path) {
        List<String> result = new ArrayList<>(path.size());
        for (int i = 0; i < path.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < path.size(); j++) {
                if (path.get(i) == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    public boolean detectAttack(List<Integer> path) {
        int curIdx = path.size() - 1;
        for (int p = curIdx - 1; p >= 0; p--) {
            if (Math.abs(path.get(curIdx) - path.get(p)) == (curIdx - p)) {
                return true;
            }
        }
        return false;
    }

}
