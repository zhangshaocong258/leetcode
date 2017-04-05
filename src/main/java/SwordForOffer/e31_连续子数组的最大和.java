package SwordForOffer;

/**
 * Created by zsc on 2017/4/2.
 * 加上一个数后小于0，则前面的数全部抛弃
 */
public class e31_连续子数组的最大和 {
    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};
        int[] data4 = {1};
        int[] data5 = {-8,10};
        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
        System.out.println(findGreatestSumOfSubArray(data4));
        System.out.println(findGreatestSumOfSubArray(data5));
    }

    private static int findGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }

        int cur = arr[0];
        int res = cur;

        //method1
        for (int i = 1; i < arr.length; i++) {
            if (cur <= 0) {
                cur = arr[i];
            } else {
                cur += arr[i];
            }
            if (res < cur) {
                res = cur;
            }
        }


//        //method2,第五组数据出错
//        for (int i = 1; i < arr.length; i++) {
//            cur += arr[i];
//            res = Math.max(res, cur);
//            cur = cur > 0 ? cur : 0;
//        }

        return res;
    }
}
