package base;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zsc on 2017/2/10.
 * 基数排序
 * 相对于桶排序，没有Collections.sort
 */
public class RadixSort {


    public static void main(String args[]) {
        int[] a = {278, 109, 63, 30, 589, 184, 505, 269, 8, 83};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(int[] a) {
        int num = getNum(a);//得到位数
        for (int i = 0; i <= num - 1; i++) {
            List<List<Integer>> lists = distribute(a, i);//分配
            collecte(a,lists);//收集

        }
    }

    private static List<List<Integer>> distribute(int[] a, int n) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        for (int i = 0; i < 10; i++) {
            lists.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < a.length; i++) {
            lists.get(getBit(a[i], n)).add(a[i]);
        }
        return lists;

    }

    public static void collecte(int[] a, List<List<Integer>> buf) {
        int k = 0;
        for(List<Integer> bucket : buf) {
            for(int ele : bucket) {
                a[k++] = ele;
            }
        }

    }

    //得到第n位数字，倒数
    private static int getBit(int a, int n) {
        String temp = String.valueOf(a);
        int bit = 0;
        if (n <= temp.length() - 1) {
            bit = temp.charAt(temp.length() - n - 1) - '0';//得到数字，否则得到ascii
     }
        return bit;
    }

    //得到最大位数
    private static int getNum(int[] a) {
        int length = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = String.valueOf(a[i]).length();
            if (temp >= length) {
                length = temp;
            }
        }
        return length;
    }
}
