package leetcode;

import java.util.HashMap;

/**
 * Created by zsc on 2017/1/30.
 * 求两个数相加等于一个数
 * 两数之和
 */
public class TwoSum {
    public static void main(String args[]) {
        solution1 solution1 = new solution1();
        int[] a = {0, 4, 3, 0};
        int[] result = solution1.twoSum(a, 0);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }

        int[] result2 = solution1.twoSum2(a, 0);
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);

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

    public int[] twoSum2(int[] numbers, int target) {

        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        //存的是需要的数和第一个数位置
        for(int i = 0; i < numbers.length; i++){
            m.put(target - numbers[i], i);
        }

        //遍历，在数组中寻找需要的数，若找到，并且第二个数位置v与第一个数位置i不同，则输出结果，输出的是位置
        for(int i = 0; i < numbers.length; i++){
            Integer v = m.get(numbers[i]);
            if(v != null && v != i){
                return new int[]{i + 1, v + 1};
            }
        }

        throw new RuntimeException();
    }
}
