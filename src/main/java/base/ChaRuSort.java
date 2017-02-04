package base;

/**
 * Created by zsc on 2017/2/3.
 * 两次循环，外层n-1次，内层从后往前比较，大于target则后移，最终确定插入位置
 */
public class ChaRuSort {
    public static void main(String args[]) {
        int[] a = {2, 3, 1, 5, 8, 4, 6};
        sort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int target = a[i];
                a[i] = a[i - 1];
                while (j >= 0 && target < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = target;
            }
        }
    }
}
