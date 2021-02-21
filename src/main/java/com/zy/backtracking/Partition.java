package com.zy.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割问题
 */
public class Partition {

    /**
     * 131. Palindrome Partitioning
     * https://leetcode-cn.com/problems/palindrome-partitioning/
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionBacktracking(s, 0, result, path);
        return result;
    }

    private void partitionBacktracking(String s, int startIdx, List<List<String>> result, List<String> path) {
        if (startIdx >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            if (isPalindrome(s, startIdx, i)) {
                path.add(s.substring(startIdx, i + 1));
            } else {
                continue;
            }
            partitionBacktracking(s, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
    // 左闭右闭区间 [l,r]
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 93. Restore IP Addresses
     * https://leetcode-cn.com/problems/restore-ip-addresses/
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        restoreIpAddressesBacktracking(s.toCharArray(), 0, result, path);
        return result;
    }

    private void restoreIpAddressesBacktracking(char[] s, int startIdx, List<String> result, List<Integer> path) {
        if (path.size() == 3) {
            if (isValid(s, path.get(2) + 1, s.length - 1)) {
                StringBuilder sb = new StringBuilder(s.length + 3);
                sb.append(s, 0, path.get(0) + 1).append(".");
                sb.append(s, path.get(0) + 1, path.get(1) - path.get(0)).append(".");
                sb.append(s, path.get(1) + 1, path.get(2) - path.get(1)).append(".");
                sb.append(s, path.get(2) + 1, s.length - 1 - path.get(2));
                result.add(sb.toString());
            }
            return;
        }

        for (int i = startIdx; i < s.length; i++) {
            if (!isValid(s, startIdx, i)) {
                break;
            }
            path.add(i);
            restoreIpAddressesBacktracking(s, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
    private boolean isValid(char[] chars, int start, int end) {
        if (start > end || (chars[start] == '0' && (start < end))) {
            return false;
        }
        int sum = 0;
        while (start <= end) {
            sum = sum * 10 + (chars[start++] - '0');
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }

}
