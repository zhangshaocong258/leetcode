package xiecheng;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/20.
 * 最大利润
 * 8（表示数组长度）
 * 1（开始依次输入数组元素）
 * 2
 * 3
 * 5
 * 2
 * 6
 * 3
 * 7
 * 2（输入k）
 */
public class Part3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int stockPrice[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                stockPrice[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            getMaxProfit(n, stockPrice, k);
        }
        scanner.close();
    }

    private static void getMaxProfit(int n, int stockPrice[], int k) {
        int cur = -1000000000;
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(stockPrice[i] + cur, dp[i - 1]);
            if (i >= k) {
                //当i=5时，要2天后才能买入，所以找到dp[3](利润)，再减去当前的stockPrice[5]，当i=6时，直接相加，可以得到最大利润
                //相当于是多加了个dp[i - k]
                cur = Math.max(cur, dp[i - k] - stockPrice[i]);
            } else {
                cur = Math.max(cur, -stockPrice[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + "  ");
        }
        System.out.println();
        System.out.println(dp[dp.length - 1]);
    }
}
