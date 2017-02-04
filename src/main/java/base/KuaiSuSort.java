package base;

/**
 * Created by zsc on 2017/2/4.
 * 快速排序
 * 因为在最后两个指针相遇的时候，要交换基准数到相遇的位置。
 * 一般选取第一个数作为基准数，那么就是在左边，所以最后相遇的数要和基准数交换，那么相遇的数一定要比基准数小。
 * 所以j指针先移动才能先找到比基准数小的数。
 */
public class KuaiSuSort {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(a, left, right);
        quickSort(a, left, pivotPos - 1);
        quickSort(a, pivotPos + 1, right);

    }

    private static int partition(int[] a, int left, int right) {
        int pivotValue = a[left];
        int pivotPos = left;

        while (left < right) {
            while (left < right && a[right] >= pivotValue) {
                right--;
            }

            while (left < right && a[left] <= pivotValue) {
                left++;
            }

            swap(a, left, right);
        }

        swap(a, pivotPos, left);
        return left;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
