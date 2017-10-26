package DP;

/**
 * Created by zsc on 2017/8/29.
 * 最长重复子串
 * 暴力解法
 */
public class LRS {

    public static void main(String[] args) {
        String X = "ask not what your country can do for you,but what you can do for your country";
        //String Y = "acaccbabb";
        System.out.println(naiveLRS(X));
    }

    // O(n^3)
    public static int naiveLRS(String x) {
        int maxLen = 0;
        int length = x.length();
        for (int i = 0; i < length; i++) {
            int len = 0;
            int k = i;//第一个游标 k
            //第二个游标j
            for (int j = i + 1; j < length; j++) {
                len = statLen(x, k, j);
                if (maxLen < len) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    private static int statLen(String X, int k, int j) {
        int cur_len = 0;
        while (k < X.length() && j < X.length() && X.charAt(k) == X.charAt(j)) {
            k++;
            j++;
            cur_len++;
        }
        return cur_len;
    }

}
