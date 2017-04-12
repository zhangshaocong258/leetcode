package sort;

import java.util.Arrays;

/**
 * Created by zsc on 2017/2/9.
 * 计数排序
 */
public class CountSort {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int max = max(arr);

        int[] count = new int[max + 1];//0-97，共98个
        Arrays.fill(count, 0);//全部置为0

        //count的位置代表a中的值的大小，count某一位置的值代表a中这个值（count位置）的个数
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int k = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[k++] = i;
            }
        }

    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max)
                max = ele;
        }
        return max;
    }

}
