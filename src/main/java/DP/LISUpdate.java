package DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zsc on 2017/3/30.
 * 最长递增子序列
 * 只能得到长度，无法得到具体子串
 * 时间复杂度O(nlogn)
 */
public class LISUpdate {

    public static void main(String[] args) {

        System.out.println("输入数组：");
        int[] oldArray = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < oldArray.length; i++) {
            oldArray[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(oldArray)); //输出生成的随机数组
        System.out.println("每次遍历："); //输出每次计算时arrayOut数组的内容，便于观察
        System.out.println("长度是：" + getLength(oldArray)); //输出最长递增子序列的长度
        System.out.println("长度是：" + getLength(oldArray, oldArray.length)); //输出最长递增子序列的长度
    }


    /**
     * 动态规划
     * 设长度为N的数组为{a0，a1, a2, ...an-1)，则假定以aj结尾的数组序列的最长递增子序列长度为L(j)，
     * 则L(j)={ max(L(i))+1, i<j且a[i]<a[j] }。
     * 也就是说，我们需要遍历在j之前的所有位置i(从0到j-1)，找出满足条件a[i]<a[j]的L(i)，求出max(L(i))+1即为L(j)的值
     */

    private static int getLength(int[] arrayIn, int len) {
        int[] longest = new int[len];
        for (int i = 0; i < len; i++) {
            longest[i] = 1;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (arrayIn[j] > arrayIn[i] && longest[j] < longest[i] + 1) {
                    longest[j] = longest[i] + 1;
                }
            }
        }
        return longest[len-1];
    }

    //另一种方法，O(nlogn)
    private static int getLength(int[] arrayIn) { //获取最长递增子序列的长度

        int position;
        int len = 1;

        int[] arrayOut = new int[arrayIn.length + 1];//arrayOut[0]没有存放数据
        arrayOut[1] = arrayIn[0]; //初始化，长度为1的LIS末尾为arrayIn[0]
        for (int i = 1; i < arrayIn.length; i++) {
            position = BinarySearchPosition(arrayOut, 1, len, arrayIn[i]);
            arrayOut[position] = arrayIn[i];
            System.out.println(Arrays.toString(arrayOut));
            if (len < position) {
                len = position;
            }
        }

        return len;
    }

    private static int BinarySearchPosition(int arrayOut[], int left, int right, int key) { //二分查找要替换的位置

        int mid;

        if (arrayOut[right] < key) {
            return right + 1;
        } else {
            while (left < right) {
                mid = (left + right) / 2;
                if (arrayOut[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

    }


}
