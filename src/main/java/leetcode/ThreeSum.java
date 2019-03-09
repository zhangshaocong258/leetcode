package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zsc on 2018/10/10.
 * 三数之和
 * 难点在于满足时间复杂度要求：
 * 1.排序后重复的数字要跳过
 * 2.i start end 已经有序，而且由于1，result里面的结果必然唯一
 */
public class ThreeSum {
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int start;
        int end;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                start = i + 1;
                end = nums.length - 1;
                while (start < end) {
                    if (start != i + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    if (nums[i] + nums[start] + nums[end] < 0) {
                        start++;
                    } else if (nums[i] + nums[start] + nums[end] > 0) {
                        end--;
                    } else {
                        int[] temp = new int[]{nums[i], nums[start], nums[end]};
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(temp[0]);
                        list.add(temp[1]);
                        list.add(temp[2]);
                        result.add(list);
                        start++;
                        end--;
                    }
                }
            }

        }
        return result;
    }
}
