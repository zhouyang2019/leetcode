package com.zy.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RansomNote {

    @Test
    public void test() {
        System.out.println(canConstruct2("a", "b"));
        System.out.println(canConstruct2("aa", "ab"));
        System.out.println(canConstruct2("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            Integer val = map.get(c);
            if (val == null) {
                val = 0;
            }
            map.put(c, ++val);
        }

        for (char c : ransomNote.toCharArray()) {
            Integer val = map.get(c);
            if (val == null || val == 0) {
                return false;
            }
            map.put(c, --val);
        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : magazine.toCharArray()) {
            ++alphabet[c - 'a'];
        }
        for (char c : ransomNote.toCharArray()) {
            if (--alphabet[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
