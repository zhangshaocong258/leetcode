package DP;

/**
 * Created by zsc on 2017/8/29.
 * 最长回文子串
 */
public class LPS {
    public static void main(String args[]) {
        String str = "ababcdedcb";
        System.out.println(nativeLPS(str));
        System.out.println(getStringCount(str));
    }

    private static int nativeLPS(String str) {
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                int temp1, temp2;
                for (temp1 = i, temp2 = j; temp1 < temp2; temp1++, temp2--) {
                    if (str.charAt(temp1) != str.charAt(temp2)) {
                        break;
                    }
                }
                if (temp1 >= temp2 && j - i > maxLen) {
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
    }

    public static int getStringCount(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int k = i;
            for (int j = str.length() - 1; j > i; j--) {
                int m = j;
                while (k < m) {
                    if (str.charAt(k) == str.charAt(m)) {
                        k++;
                        m--;
                    } else {
                        break;
                    }
                }
                if (k >= m && result < j - i + 1) {
                    result = j - i + 1;
                }
            }

        }
        return result;
    }
}
