package base;

/**
 * Created by zsc on 2017/2/3.
 * 两次循环，外层n-1次，内层少i次，两两比较并交换
 */
public class MaoPaoSort {

    public static void main(String args[]) {
        int[] a = {2, 3, 1, 5, 8, 4, 6};
        sort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}