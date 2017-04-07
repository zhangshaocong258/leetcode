package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zsc on 2017/3/30.
 * 最长递增子序列
 * 只能得到长度，无法得到具体子串
 * 时间复杂度O（nlogn）
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
    }

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
