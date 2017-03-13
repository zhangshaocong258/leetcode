package leetcode;

import java.util.*;

/**
 * Created by zsc on 2017/1/30.
 * 找最长不重复子串
 * "abcabcbb" -> "abc"
 * "bbbbb" -> "b"
 * "pwwkew" -> "wke"
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        String str = "";
        System.out.println(new solution3().lengthOfLongestSubstring(str));
    }

}

class solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = 0;
        int i = 0;
        int j = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (j < s.length()) {
            if (!map.containsKey(String.valueOf(s.charAt(j)))) {
                map.put(String.valueOf(s.charAt(j)), j);
            } else {
                int length = j - i;
                if (result < length) {
                    result = length;
                }
                int index = map.get(String.valueOf(s.charAt(j)));
                i = Math.max(i, index + 1);
                map.put(String.valueOf(s.charAt(j)), j);
            }
            j++;
        }
        if (result < j - i) {
            result = j - i;
        }
        return result;
    }

}
