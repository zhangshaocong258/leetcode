package sort;

import java.util.Stack;

/**
 * Created by zsc on 2017/2/13.
 */
public class MergeSort2 {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        mSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void mSort(int[] a) {
        if (a == null || a.length == 0){
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.empty()) {
            int right = stack.pop();
            int left = stack.pop();
            //如果最大索引小于等于左边索引，说明结束了
            if (left >= right) {
                continue;
            }
            int mid = (left + right) / 2;
            merge(a, left, mid, right);

            if (left < mid) {
                stack.push(left);
                stack.push(mid);
            }

            if (mid + 1 < right) {
                stack.push(mid + 1);
                stack.push(right);
            }
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
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
