package SwordForOffer;

/**
 * Created by zsc on 2017/3/20.
 * 从1打印到n，大数
 */
public class c12_打印1到最大的n位数 {

    public static void main(String args[]) {
        printToMaxOfNDigits(4);
    }
    public static void printToMaxOfNDigits(int n) {
        // 创建一个数组用于打存放值
        int[] array = new int[n];
        if (n <= 0){
            return;
        }
        printToMaxOfNDigits(array, 0);
    }
    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param location   当前处理的是第location个元素，从0开始计数
     * @param array      存放结果的数组
     */
    private static void printToMaxOfNDigits(int[] array, int location) {
        // 说明所有的数据排列选择已经处理完了
        if (location >= array.length) {
            //打印数组的值
            printArray(array);
        } else {
            for (int i = 0; i < 10; i++) {
                array[location] = i;
                printToMaxOfNDigits(array, location + 1);
            }
        }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param array 要输出的数组
     */
    private static void printArray(int[] array) {
        // 找第一个非0的元素
        int index = 0;
        while (index < array.length && array[index] == 0) {
            index++;
        }

        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < array.length; i++) {
            System.out.print(array[i]);
        }

        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < array.length) {
            System.out.println();
        }
    }
}
