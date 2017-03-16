package offer;

/**
 * Created by zsc on 2017/3/16.
 * 第三题
 * <p>
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增．
 * 输入一个二维数组和一个整数，判断数组中是否含有整数
 */
public class FindKeyInArray {
    public static void main(String args[]) {
        int[][] testarray = new int[4][4];
        testarray[0][0] = 1;
        testarray[0][1] = 2;
        testarray[0][2] = 8;
        testarray[0][3] = 9;
        testarray[1][0] = 2;
        testarray[1][1] = 4;
        testarray[1][2] = 9;
        testarray[1][3] = 12;
        testarray[2][0] = 4;
        testarray[2][1] = 7;
        testarray[2][2] = 10;
        testarray[2][3] = 13;
        testarray[3][0] = 6;
        testarray[3][1] = 8;
        testarray[3][2] = 11;
        testarray[3][3] = 15;
        System.out.println(Find(testarray, 5));
    }

    private static boolean Find(int[][] array, int key) {
        if (array == null) {
            return false;
        }
        int col = array[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= array.length - 1) {

            if (array[row][col] == key) {
                return true;
            } else if (array[row][col] > key) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
