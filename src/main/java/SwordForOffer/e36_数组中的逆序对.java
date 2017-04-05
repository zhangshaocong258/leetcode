package SwordForOffer;

/**
 * Created by zsc on 2017/4/3.
 * count是static
 * 传参使用int[] count
 */
public class e36_数组中的逆序对 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); // 15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(inversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(inversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(inversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(inversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(inversePairs(data7)); // 3
    }

    private static int inversePairs(int[] arr) {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("args should not be null or empty");
        }
        int[] count = {0};
        mSort(arr, 0, arr.length - 1, count);
        return count[0];
    }

    private static void mSort(int[] a, int left, int right, int[] count) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mSort(a, left, mid, count);
        mSort(a, mid + 1, right, count);
        merge(a, left, mid, right, count);
    }

    private static void merge(int[] a, int left, int mid, int right, int[] count) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                count[0] += mid - i + 1;
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= right) {
            temp[k++] = a[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            a[left + p] = temp[p];
        }
    }

}
