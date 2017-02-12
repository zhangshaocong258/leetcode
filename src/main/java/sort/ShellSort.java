package sort;

/**
 * Created by zsc on 2017/2/4.
 * 希尔排序
 * 讲插入排序中的1改为d
 */
public class ShellSort {

    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void shellSort(int[] a) {
        if (a == null || a.length == 0)
            return;
        int d = a.length / 2;
        while (d >= 1) {
            shellInsert(a, d);
            d /= 2;
        }
    }

    private static void shellInsert(int[] a, int d) {
        for (int i = d; i < a.length; i++) {
            if (a[i] < a[i - d]) {
                int j = i - d;
                int target = a[i];
                a[i] = a[i - d];
                while (j >= 0 && target < a[j]) {
                    a[j + d] = a[j];
                    j -= d;
                }
                a[j + d] = target;
            }

        }
    }

}
