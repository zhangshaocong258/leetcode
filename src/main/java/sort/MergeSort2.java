package sort;


/**
 * Created by zsc on 2017/2/13.
 * 非递归归并排序
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
        int len = 1;

        while (len < a.length) {
            for (int i = 0; i < a.length; i += 2 * len) {
                merge(a, i, len);
            }
            len *= 2;
        }
    }

    private static void merge(int[] a, int i, int len) {
        int[] temp = new int[len * 2];
        int start = i;
        int mid = i + len;
        int j = i + len;
        int end = j + len;
        int k = 0;
        while (i < mid && j < end && j < a.length) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i < mid && i < a.length) {
            temp[k++] = a[i++];
        }

        while (j < end & j < a.length) {
            temp[k++] = a[j++];
        }

        k = 0;
        while(start < j && start < a.length){
            a[start++] = temp[k++];
        }

        //start + p超过数组大小，报错
        /*for (int p = 0; (p < temp.length ); p++) {
            try {
                a[start + p] = temp[p];
            } catch (Exception e) {
                System.out.println(" sta " + start + " p " + p + "  tt " + temp.length);

                e.printStackTrace();
                System.exit(0);
            }
        }*/
    }
}
