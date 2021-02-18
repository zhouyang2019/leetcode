package com.zy.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring2(""));
        System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
        System.out.println(lengthOfLongestSubstring2("jbpnbwwd"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring2("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }

        char[] chars = s.toCharArray();
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int first = 0; first < chars.length; first++) {
            set.add(chars[first]);
            for (int second = first + 1; second < chars.length; second++) {
                if (!set.add(chars[second])) {
                    max = max > set.size() ? max : set.size();
                    set.clear();
                    break;
                }
            }
        }
        max = max > set.size() ? max : set.size();
        return max;
    }

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }

        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer val = map.get(s.charAt(i));
            if (val != null) {
//                left = val + 1; // abba 这种会有问题
                left = Math.max(left, val + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(i - left + 1, max);
        }
        return max;
    }
}
