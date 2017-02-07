package base;

/**
 * Created by zsc on 2017/2/6.
 * 堆排序
 * 正确无误
 */
public class HeapSort {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        int child = 2 * start + 1;
        while (child <= end) {
            //左右孩子的节点分别为2*i+1,2*i+2
            //选择出左右孩子较大的下标
            if (child + 1 <= end && arr[child] < arr[child + 1]) {
                child++;
            }
            if (temp < arr[child]) {
                arr[start] = arr[child]; //将子节点上移
                start = child; //下一轮筛选
                child = 2 * start + 1;
            } else {
                break; //已经为大顶堆，=保持稳定性。
            }
            arr[start] = temp; //插入正确的位置，可在while循环外面
        }
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        //建立大顶堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
            if (i == 1 || i == 0) {
                System.out.println("*****");
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j]);
                }
                System.out.println("*****");
            }
        }
        System.out.println("*****");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("*****");

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i - 1);
        }

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
