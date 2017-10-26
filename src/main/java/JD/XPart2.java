package JD;

import java.util.Scanner;

/**
 * Created by zsc on 2017/9/8.
 */
public class XPart2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        if (Math.pow(a, b) == Math.pow(c, d)) {
                            System.out.println(a + "\t" + b + "\t" + c + "\t" + d);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count % 1000000007);
    }
}
