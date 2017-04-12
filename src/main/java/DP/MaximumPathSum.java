package DP;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/9.
 * m*n的矩阵，只能向右走或是向下走，矩阵每一个元素代表一个财富值，要求打印出从左上角到右下角走的财富最大总值。
 * m=4 ,n=5
 * 0 0 7 0 0
 * 0 0 0 5 0
 * 2 0 4 0 0
 * 0 0 0 3 0
 * 最大为15
 */
public class MaximumPathSum {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] value = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                value[i][j] = scanner.nextInt();
            }
        }

        //得到第一列的最大值
        for (int i = 1; i < m; i++) {
            value[i][0] += value[i - 1][0];
        }

        //得到第一行的最大值
        for (int j = 1; j < n; j++) {
            value[0][j] += value[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                value[i][j] += Math.max(value[i - 1][j], value[i][j - 1]);
            }
        }
        System.out.println(value[m - 1][n - 1]);

    }

}
