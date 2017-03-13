package leetcode;

/**
 * Created by zsc on 2017/1/30.
 * 求两个数相加等于一个数
 */
public class TwoSum {
    public static void main(String args[]) {
        solution1 solution1 = new solution1();
        int[] a = {0, 4, 3, 0};
        for (int i = 0; i < solution1.twoSum(a, 0).length; i++) {
            System.out.println(solution1.twoSum(a, 0)[i]);

        }
    }
}

class solution1{
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
