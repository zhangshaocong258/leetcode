package xiecheng;

import java.util.Scanner;

/**
 * Created by zsc on 2017/4/18.
 * 携程第一题，15分成若干个不同的数，相乘最大
 * http://discuss.acmcoder.com/topic/58ecd4fe243952b61f1a2851
 */
public class Part1 {
    public static void main(String[] args) {
        int a, c, d, h, k, n, s;
        int t;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = 0;
        h = 0;
        a = 1;
        while (s <= n) {
            a++;
            s += a;
        }
        if (s - n == a) {
            c = 2;
            d = a - 1;
        } else if (s - n == 2) {
            c = 3;
            d = a;
        } else if (s - n == 1) {
            c = 3;
            d = a + 1;
            h = a;
        } else {
            c = 2;
            d = a;
            h = s - n;
        }
        t = 1;
        for (k = c; k <= d; k++)
            t *= k;
        if (h > 0)
            t /= h;

        System.out.println(t);

    }

}
