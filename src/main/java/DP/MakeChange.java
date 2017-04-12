package DP;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/10.
 * 给定数量不限的硬币，计算得到n有几种表示法
 * 初始化第一行、第一列的时候务必注意值一定要正确！！！
 * 硬币种类，硬币面值，n的值
 * 3
 * 1 2 4
 * 3
 * 返回2
 * 4
 * 2 5 3 6
 * 10
 * 返回5
 *
 * 3
 * 1 2 3
 * 4
 * 返回4
 */
public class MakeChange {
    public static void main(String args[]) {
//        function1();
        function2();
    }

    //博客上的
    private static void function1() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];//每个硬币的价值

        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }

        //需要求得n
        int aim = scanner.nextInt();

        //可以装前count个硬币时，总钱数小于aim时的种数
        int dp[][] = new int[count][aim + 1];

        for (int col = 0; col < count; col++) {
            dp[col][0] = 1;
        }

        //直接初始化有一个硬币的情况
        for (int row = 1; arr[0] * row < aim + 1; row++) {
            dp[0][arr[0] * row] = 1;
        }

        for (int coin = 1; coin < count; coin++) {
            for (int money = 1; money < aim + 1; money++) {
                if (money >= arr[coin]) {
                    //当钱大于当前添加的硬币时，当前硬币可以添加进来，计算添加当前硬币和不添加当前硬币
                    dp[coin][money] = dp[coin - 1][money] + dp[coin][money - arr[coin]];
                } else {
                    //钱小于当前硬币，则不添加
                    dp[coin][money] = dp[coin - 1][money];
                }
            }
        }

        for (int[] rows : dp) {
            for (int col : rows) {
                System.out.printf("%5d", col);
            }
            System.out.println();
        }

        System.out.println(dp[count - 1][aim]);
    }

    //小改，count变为count+1，第一行不用初始化（为0），在整个循环的时候初始化第二行（有一个硬币）
    private static void function2() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];//每个硬币的价值

        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }

        //需要求得n
        int aim = scanner.nextInt();

        //可以装前count个硬币时，总钱数小于aim时的种数
        int dp[][] = new int[count + 1][aim + 1];

        for (int col = 0; col < count + 1; col++) {
            dp[col][0] = 1;
        }

//        for (int row = 1; arr[0] * row < aim + 1; row++) {
//            dp[0][arr[0] * row] = 1;
//        }

        for (int coin = 1; coin < count + 1; coin++) {
            for (int money = 1; money < aim + 1; money++) {
                if (money >= arr[coin - 1]) {
                    //当钱大于当前添加的硬币时，当前硬币可以添加进来，计算添加当前硬币和不添加当前硬币
                    dp[coin][money] = dp[coin - 1][money] + dp[coin][money - arr[coin - 1]];
                } else {
                    //钱小于当前硬币，则不添加
                    dp[coin][money] = dp[coin - 1][money];
                }
            }
        }

        for (int[] rows : dp) {
            for (int col : rows) {
                System.out.printf("%5d", col);
            }
            System.out.println();
        }

        System.out.println(dp[count][aim]);
    }
}
