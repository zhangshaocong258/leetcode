package base;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zsc on 2017/2/10.
 */
public class TongSort {
    public static void main(String args[]) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4, 48};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(int[] a) {
        if (a == null && a.length == 0) {
            return;
        }
        int tongCount = 10;//0-100

        //初始化
        List<List<Integer>> tongs = new LinkedList<List<Integer>>();
        for (int i = 0; i < tongCount; i++) {
            tongs.add(new LinkedList<Integer>());
        }

        //向每个桶添加元素
        for (int i = 0; i < a.length; i++) {
            tongs.get(f(a[i])).add(a[i]);
        }

        //对每个桶中的元素排序
        for (List<Integer> tong : tongs) {
            Collections.sort(tong);
        }

        //将排序后的元素添加至数组
        int k = 0;
        for (List<Integer> tong : tongs) {
            for (int ele : tong) {
                a[k++] = ele;
            }

        }

    }

    private static int f(int a) {
        return a / 10;

    }
}
