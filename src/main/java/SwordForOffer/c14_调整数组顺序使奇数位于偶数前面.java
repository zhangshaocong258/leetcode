package SwordForOffer;

/**
 * Created by zsc on 2017/3/20.
 */
public class c14_调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5};
//        reorderOddEvenFromInsertSort(arr);
        Reorder(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //O(N)
    public static void Reorder(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int p1 = -1;
        int p2 = arr.length;
        while (p1 < p2) {
            while (p1 < p2 && flag(arr[++p1])) ;
            while (p1 < p2 && !flag(arr[--p2])) ;
            swap(arr, p1, p2);
        }
    }

    //O(N^2)
    private static void reorderOddEvenFromInsertSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && !flag(arr[j - 1]) && flag(arr[j]); j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 判断条件：i是奇数
     *
     * @param i
     * @return
     */

    private static boolean flag(int i) {
        if ((i & 0x1) == 0) {
            return false;
        }
        return true;
    }
}
