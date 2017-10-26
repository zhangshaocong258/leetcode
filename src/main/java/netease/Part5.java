package netease;

import java.util.Scanner;

/**
 * Created by zsc on 2017/8/13.
 * Part4动态规划方法
 * dp[n+1][k+1]表示长度为n时，最后一个数为k是符合要求数的个数
 */
public class Part5 {
    static int n;
    static int k;
    static int result = 0;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <= k; m++) {
                    if (m <= j || m % j != 0) {
                        dp[i][j] += dp[i - 1][m];
                        dp[i][j] = dp[i][j] % 1000000007;
                    }
                }
            }
        }
        for (int i = 1; i <= k; i++) {
            result += dp[n][i];
            result = result % 1000000007;
        }
        System.out.println(result);
    }
}
