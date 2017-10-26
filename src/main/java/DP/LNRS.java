package DP;

import java.util.HashMap;

/**
 * Created by zsc on 2017/8/29.
 * 最长不重复子串
 * 暴力算法，使用hash
 */
public class LNRS {
    public static void main(String args[]) {
        String str = "abcadcefa";
        System.out.println(hashLNRS(str));
    }

    private static int hashLNRS(String str) {
        int maxLen = 0;
        HashMap<Character, Integer> hashMap;
        for (int i = 0; i < str.length(); i++) {
            hashMap = new HashMap<Character, Integer>();
            hashMap.put(str.charAt(i), 1);
            int j;
            for (j = i + 1; j < str.length(); j++) {
                if (!hashMap.containsKey(str.charAt(j))) {
                    hashMap.put(str.charAt(j), 1);
                } else {
                    if (j - i > maxLen) {
                        maxLen = j - i;
                    }
                    break;
                }
            }
            if (j - i > maxLen) {
                maxLen = j - i;
            }
        }
        return maxLen;
    }

}
