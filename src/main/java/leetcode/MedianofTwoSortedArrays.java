package leetcode;

/**
 * Created by zsc on 2018/10/7.
 * 两个排序数组的中位数
 * 要求算法的时间复杂度为 O(log (m+n))
 */
public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});

    }
}

/**
 * 时间复杂度？
 * 参考原答案吧
 */
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = -1;
        int[] temp = new int[nums1.length + nums2.length];
        int mid = (nums1.length + nums2.length) / 2;
        int flag = (nums1.length + nums2.length) % 2;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i <= nums1.length - 1 && j <= nums2.length - 1) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            if (k == mid) {
                if (flag == 1) {
                    result = temp[k];
                } else {
                    result = (double) (temp[k] + temp[k - 1]) / 2;
                }            }
            k++;
        }
        while (i <= nums1.length - 1){
            temp[k] = nums1[i];
            i++;
            if (k == mid) {
                if (flag == 1) {
                    result = temp[k];
                } else {
                    result = (double) (temp[k] + temp[k - 1]) / 2;
                }            }
            k++;
        }
        while (j <= nums2.length - 1){
            temp[k] = nums2[j];
            j++;
            if (k == mid) {
                if (flag == 1) {
                    result = temp[k];
                } else {
                    result = (double) (temp[k] + temp[k - 1]) / 2;
                }
            }
            k++;
        }

        return result;
    }
}
