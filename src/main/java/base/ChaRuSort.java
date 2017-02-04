package base;

/**
 * Created by zsc on 2017/2/3.
 * 两次循环，外层n-1次，内层从后往前比较，大于target则后移，最终确定插入位置
 *
 */
public class ChaRuSort {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        sort(a, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(int[] a, int n) {
        for (int i = 1; i < n; i++) {//外层循环次数
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int target = a[i];
                a[i] = a[i - 1];
                while (j >= 0 && target < a[j]) {//寻找插入位置
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = target;//找到位置，插入target
            }
        }
    }
}
