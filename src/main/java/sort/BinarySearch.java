package sort;

/**
 * Created by zsc on 2017/4/6.
 * 二分查找
 */
public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 11));
    }

    private static int binarySearch(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
