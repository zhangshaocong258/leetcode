package baidu;

import java.util.Scanner;

/**
 * Created by zsc on 2017/5/5.
 * 不等式序列
 */
public class Part2 {
    static int bigger = 0;
    static int biggerOri = 0;
    static int smaller = 0;
    static int smallerOri = 0;
    static int result = 0;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int start = 0;
        int list[] = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }
        bigger = n - k - 1;
        biggerOri = n - k - 1;
        smaller = k;
        smallerOri = k;
        gen(list, start, n);
        System.out.println(result % 2017);


    }

    public static void gen(int[] list, int start, int length) {
        int i;
        if (start == length) {
            for (i = 0; i < length - 1; i++) {
                if (list[i] < list[i + 1]) {
                    smaller--;
                } else {
                    bigger--;
                }

            }
            if (bigger ==0 && smaller ==0) {
                result++;
            }
            bigger = biggerOri;
            smaller = smallerOri;
        } else {
            for (i = start; i < length; i++) {
                swap(list, start, i);
                gen(list, start + 1, length);
                swap(list, start, i);
            }
        }
    }

    public static void swap(int[] list, int start, int i) {
        int temp;
        temp = list[start];
        list[start] = list[i];
        list[i] = temp;
    }
}
