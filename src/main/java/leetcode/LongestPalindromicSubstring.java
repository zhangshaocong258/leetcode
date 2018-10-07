package leetcode;

/**
 * Created by zsc on 2018/10/7.
 * 最长回文子串
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        s.longestPalindrome("babad");
    }
}

class Solution5{
    public String longestPalindrome(String s) {
        int result = 0;
        int start = 0;
        int end;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLen(s, i, i);
            int len2 = getLen(s, i, i + 1);
            if (result < Math.max(len1, len2)) {
                result = Math.max(len1, len2);
                start = i - (result - 1) / 2;
            }
        }
        end = start + result;
        return s.substring(start, end);
    }

    public int getLen(String s, int i, int j) {
        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
