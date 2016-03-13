package leetcode;

import java.util.HashSet;

/**
 * Created by zsc on 2016/3/1.
 */
class Solution217{
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set= new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}

public class ContainsDuplicate {
    public static void main(String[] args ){
        int[] num217 = {1,2};
        boolean result = new Solution217().containsDuplicate(num217);
        System.out.println(result);
    }
}
