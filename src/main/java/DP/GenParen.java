package DP;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/10.
 * 打印n对括号的全部有效组合
 * 仅仅是递归
 * n=3
 * (()())   ((()))  ()(())  (())()  ()()()
 */
public class GenParen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] str = new char[2 * n];
        genParen(str, n, n, 0);
    }

    private static void genParen(char[] str, int left, int right, int count) {
        if (left < 0 || right < 0) {
            return;
        }

        if (left == 0 && right == 0) {
            String s = String.copyValueOf(str);
            System.out.println(s);
        } else {
            if (left > 0) {
                str[count] = '(';
                genParen(str, left - 1, right, count + 1);
            }

            if (right > left) {
                str[count] = ')';
                genParen(str, left, right - 1, count + 1);
            }
        }
    }
}
