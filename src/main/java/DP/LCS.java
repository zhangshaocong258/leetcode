package DP;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/11.
 * 最长公共子序列
 * 可以不相邻
 * 10
 * 12
 * 1A2C3D4B56
 * B1D23CA45B6A
 */
public class LCS {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.valueOf(scanner.nextLine());
        int b = Integer.valueOf(scanner.nextLine());

        String strA = scanner.nextLine();
        String strB = scanner.nextLine();

        char[] charA = strA.toCharArray();
        char[] charB = strB.toCharArray();

        int[][] dp = new int[a + 1][b + 1];
        //写法1
        for (int i = 1; i < a + 1; i++) {
            for (int j = 1; j < b + 1; j++) {
                if (charA[i - 1] == charB[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //写法1end

        //写法2
//        for (int i = 0; i < a + 1; i++) {
//            dp[i][0] = 0;
//        }
//
//        for (int i = 0; i < b + 1; i++) {
//            dp[0][i] = 0;
//        }
//
//        for (int i = 1; i < a + 1; i++) {
//            if (charA[i - 1] == charB[0]) {
//                dp[i][1] = 1;
//                for (int j = i + 1; j < a + 1; j++) {
//                    dp[j][1] = 1;
//                }
//                break;
//            }
//        }
//
//        for (int i = 1; i < b + 1; i++) {
//            if (charB[i - 1] == charA[0]) {
//                dp[1][i] = 1;
//                for (int j = i + 1; j < b + 1; j++) {
//                    dp[1][j] = 1;
//                }
//                break;
//            }
//        }
//
//        for (int i = 2; i < a + 1; i++) {
//            for (int j = 2; j < b + 1; j++) {
//                if (charA[i - 1] == charB[j - 1]) {
//                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i][j - 1], dp[i - 1][j]));
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                }
//            }
//        }
        //写法2end

        for (int[] rows : dp) {
            for (int col : rows) {
                System.out.printf("%5d", col);
            }
            System.out.println();
        }

        System.out.println(dp[a][b]);
        int i = a, j = b;
        while (i > 0 && j > 0) {
            if (charA[i - 1] == charB[j - 1]) {
                System.out.print(charA[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println();
    }

}
