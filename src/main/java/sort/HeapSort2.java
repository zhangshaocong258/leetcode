package sort;

/**
 * Created by zsc on 2017/2/7.
 * i *= 2 有错，最后答案正确 @Deprecated
 */
public class HeapSort2 {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    private static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];

        System.out.println("start " + start);
        for (int i = 2 * start + 1; i <= end; i *= 2) {
            //左右孩子的节点分别为2*i+1,2*i+2
            System.out.println("i1 " + i);

            //选择出左右孩子较小的下标
            if (i < end && arr[i] < arr[i + 1]) {
                i++;
            }
            System.out.println("i2 " + i);

            if (temp >= arr[i]) {
                System.out.println("break");
                break; //已经为大顶堆，=保持稳定性。
            }
            arr[start] = arr[i]; //将子节点上移
            start = i; //下一轮筛选
        }
        arr[start] = temp; //插入正确的位置
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        //建立大顶堆
        for (int i = arr.length / 2; i >= 0; i--) {
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
