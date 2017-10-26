package SwordForOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2017/9/14.
 * 先分解因数，然后判断是不是素数
 *
 */
public class 分解质因数 {
    public static void main(String args[]) {
        int n = 24;
        System.out.println(resolve(n));
    }

    private static List<Integer> resolve(int n) {
        List<Integer> list = new ArrayList<Integer>();
        out:
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                if (n != 1) {
                    n = n / i;
                    if (isPrime(i)) {
                        list.add(i);
                    }
                } else {
                    break out;
                }
            }
        }
        return list;
    }

    //判断是否是素数
    private static boolean isPrime(int n) {
        if (n <= 2 || n % 2 == 0) {
            return false;
        }
        n = (int) Math.sqrt(n);
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
