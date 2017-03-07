package sort;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zsc on 2017/2/12.
 * 非递归快排
 * 用堆栈存储右左、右左...
 * 每次取一个进行排序，若left >= right，则跳过，执行下一个
 * 顺序从最右到左
 */
public class KuaiSuSort2 {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void quickSort(int[] a) {
        if (a == null || a.length == 0){
            return;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            //如果最大索引小于等于左边索引，说明结束了
            if (left >= right) {
                continue;
            }
            int pivotPos = partition(a, left, right);

            if (left < pivotPos - 1) {
                stack.push(left);
                stack.push(pivotPos - 1);
            }

            if (pivotPos + 1 < right) {
                stack.push(pivotPos + 1);
                stack.push(right);
            }
        }


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
