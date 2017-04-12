package DP;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/9.
 * 背包问题
 * 10
 * 4
 * 10 40 30 50
 * 5 4 6 3
 */
public class Knapsack {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int weights = scanner.nextInt();//背包可容纳重量
        int n = scanner.nextInt();//物品数量
        int[] each_v = new int[n];//每个物品的价值
        int[] each_w = new int[n];//每个物品的重量
        for (int i = 0; i < n; i++) {
            each_v[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            each_w[i] = scanner.nextInt();
        }

        //可以装前n个物品时，重量小于weight的最大价值
        int[][] values = new int[n + 1][weights + 1];
        for (int col = 0; col < weights + 1; col++) {
            values[0][col] = 0;
        }
        for (int row = 0; row < n + 1; row++) {
            values[row][0] = 0;
        }

        for (int item = 1; item < n + 1; item++) {
            for (int weight = 1; weight < weights + 1; weight++) {
                if (each_w[item - 1] <= weight) {
                    //装上当前物品的价值，不装当前物品的价值
                    values[item][weight] = Math.max(each_v[item - 1] + values[item - 1][weight - each_w[item - 1]],
                            values[item - 1][weight]);
                } else {
                    values[item][weight] = values[item - 1][weight];
                }
            }
        }

        for (int[] rows : values) {
            for (int col : rows) {
                System.out.printf("%5d", col);
            }
            System.out.println();
        }

        System.out.println(values[n][weights]);


    }
}
