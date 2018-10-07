package leetcode;

import java.util.*;

/**
 * Created by zsc on 2017/1/30.
 * 找最长不重复子串
 * "abcabcbb" -> "abc"
 * "bbbbb" -> "b"
 * "pwwkew" -> "wke"
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

    /**
     * index表示没有重复字符的最长子字符串的起始索引，i表示当前位置
     *
     * @param s 字符串
     * @return 长度
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] arrays = s.toCharArray();
        int result = 0;
        int index = 0;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < arrays.length; i++) {
            if (hashMap.containsKey(arrays[i])) {
                index = Math.max(index, hashMap.get(arrays[i]) + 1);
                hashMap.put(arrays[i], i);
            }
            result = Math.max(result, i - index + 1);
            hashMap.put(arrays[i], i);
        }
        return result;
    }

}
