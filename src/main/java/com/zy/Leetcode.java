package com.zy;

import java.util.*;

public class Leetcode {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        ListNode l1p = l1;
        ListNode l2p = l2;
        int bit = 0; // 进位标志，只可能为 0 或者 1
        while (l1p != null && l2p != null) {
            int val = l1p.val + l2p.val + bit; // 和
            bit = val / 10;
            ListNode tmp = new ListNode(val % 10);
            p.next = tmp;
            p = p.next;
            l1p = l1p.next;
            l2p = l2p.next;
        }

        ListNode lp = null;
        if (l1p == null) {
            lp = l2p;
        } else {
            lp = l1p;
        }
        while (lp != null) {
            int val = lp.val + bit;
            bit = val / 10;
            ListNode tmp = new ListNode(val % 10);
            p.next = tmp;
            p = p.next;
            lp = lp.next;
        }

        if (bit > 0) {
            p.next = new ListNode(bit);
        }

        return soldier.next;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0, t = nums.length - 1;
        while (i < t) {
            if (nums[i] == val) {
                nums[i] = nums[t--];
            } else {
                i++;
            }
        }
        if (nums[t] == val) {
            t--;
        }
        return t + 1;
    }

    public int removeDuplicates(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int t = i; t < nums.length - 1 - offset; t++) {
                    nums[t] = nums[t + 1];
                }
            }
        }
        for (int i = nums.length - offset - 1; i < nums.length - 1; i++) {
            nums[i] = 0;
        }
        return nums.length - offset;
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                continue;
            } else {
                return i;
            }
        }
        return nums.length;
    }

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long left = 0, right = x;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        rst.add(l1);
        rst.add(l2);
        if (numRows == 1) {
            rst.remove(1);
            return rst;
        }
        if (numRows == 2) {
            return rst;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> pre = rst.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            rst.add(cur);
        }
        return rst;
    }

    public static void main(String[] args) {
//        ListNode la0 = new ListNode(1);
//        ListNode la1 = new ListNode(2);
//        la0.next = la1;
//        ListNode la2 = new ListNode(1);
//        la1.next = la2;

//        ListNode lb0 = new ListNode(9);
//        ListNode lb1 = new ListNode(9);
//        lb0.next = lb1;
//
//        ListNode rst = addTwoNumbers(la0, lb0);
//        while (rst != null) {
//            System.out.println(rst.val);
//            rst = rst.next;
//        }
//        System.out.println(isPalindrome(la0));


//        StringBuffer sb = new StringBuffer();
//        sb.append(Character.toChars(127850)); // 有些字符是用两个 char 来表示的
//        System.out.println(sb); // 输出 🍪

//        for (int i=0; i<10; i++) {
//            System.out.println(i);
//            if (i == 2) {
//                i = 9;
//            }
//        }

        for (int i = 0; i < 10; i++) {
            try {
                throw new IllegalArgumentException("fuck");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            for (int i = 0; i < 10; i++) {
                throw new IllegalArgumentException("haha");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 找到中心节点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 中心节点处（即 slow.next）开始反转
        ListNode prev = slow;
        // 链表为偶数个节点时
        if (fast != null) {
            prev = slow.next;
        }
        ListNode curr = prev.next;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        if (fast != null) {
            slow.next = null;
        }

        // 遍历比较前后两个链表
        ListNode p = head;
        ListNode q = prev;
        while (p != null || q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charS.length; i++) {
//            alphabet[charS[i] - 'a']++;
//            alphabet[charT[i] - 'a']--;
            Integer numS = map.get(charS[i]);
            if (numS == null) {
                map.put(charS[i], 1);
            } else {
                map.put(charS[i], numS + 1);
            }

        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        // 增序排序
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int j = i -1;
            for (; j >= 0; j--) {
                if (curr[0] < intervals[j][0]) {
                    intervals[j+1] = intervals[j];
                } else {
                    break;
                }
            }
            intervals[j+1] = curr;
        }

//        int startIdx = 0;
//        for (int i = 0; i < intervals.length - 1; i++) {
//            for (int j = i+1; j < intervals.length; j++) {
//                // 左边界交换
//                if (intervals[i][1] >= intervals[j][0]) {
//                    intervals[j][0] = intervals[i][0];
//                    // 右边界交换
//                    if (intervals[i][1] > intervals[j][1]) {
//                        intervals[j][1] = intervals[i][1];
//                    }
//                    i = j;
//                    startIdx = j;
//                    break;
//                }
//            }
//        }

//        int startIdx = recursionMerge(intervals);
//
//        List<int[]> list = new ArrayList<>();
//        for (; startIdx < intervals.length; startIdx++) {
//            list.add(intervals[startIdx]);
//        }
//
//        return list.toArray(new int[0][0]);

        recursionMerge(intervals);
        return intervals;
    }

    public static int recursionMerge(int[][] intervals) {
        int startIdx = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                // 左边界交换
                if (intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = intervals[i][0];
                    // 右边界交换
                    if (intervals[i][1] > intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    i = j;
                    startIdx = j;
                    break;
                }
            }
        }

        if (startIdx == 0) {
            return startIdx;
        } else {
            List<int[]> list = new ArrayList<>();
            for (; startIdx < intervals.length; startIdx++) {
                list.add(intervals[startIdx]);
            }
            intervals = list.toArray(new int[0][0]);
            int rst = recursionMerge(intervals);
            return rst;
        }
    }

    public void sortColors(int[] nums) {
        int[] bucket = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        for (int i = 0; i < bucket[0]; i++) {
            nums[i] = 0;
        }
        for (int i = bucket[0]; i < bucket[1]; i++) {
            nums[i] = 1;
        }
        for (int i = bucket[1]; i < bucket[2]; i++) {
            nums[i] = 2;
        }
    }

}
