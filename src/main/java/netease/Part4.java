package netease;
import java.util.Scanner;

/**
 * Created by zsc on 2017/8/12.
 *
 * 小易非常喜欢拥有以下性质的数列:
 1、数列的长度为n
 2、数列中的每个数都在1到k之间(包括1和k)
 3、对于位置相邻的两个数A和B(A在B前),都满足(A <= B)或(A mod B != 0)(满足其一即可)
 例如,当n = 4, k = 7
 那么{1,7,7,2},它的长度是4,所有数字也在1到7范围内,并且满足第三条性质,所以小易是喜欢这个数列的
 但是小易不喜欢{4,4,4,2}这个数列。小易给出n和k,希望你能帮他求出有多少个是他会喜欢的数列。
 输入描述:
 输入包括两个整数n和k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)


 输出描述:
 输出一个整数,即满足要求的数列个数,因为答案可能很大,输出对1,000,000,007取模的结果。

 输入例子1:
 2 2

 输出例子1:
 3
 *
 * 暴力解决，回溯法
 */
public class Part4 {
    static int n;
    static int k;
    static int count = 0;
    static int result = 0;
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        int[] array = new int[n];
        fun(array, 0);
        System.out.println(result % 1000000007);
    }

    public static void fun(int[] array, int bucket) {

        if (bucket == n - 1) {
            for (int j = 1; j <= k; j++) {
                array[bucket] = j;
//                for (int i = 0; i < n; i++) {
//                    System.out.println("array " + array[i]);
//                }
                for (int i = 0; i < n-1; i++) {
                    if (array[i] <= array[i + 1] || array[i] % array[i + 1] != 0) {
                        count++;
                    }
                }
                if (count == n-1) {
                    result++;
                }
                count = 0;
            }
            return;
        }

        for (int j = 1; j <= k; j++) {
            array[bucket] = j;
            fun(array, bucket + 1);
        }
    }
}

