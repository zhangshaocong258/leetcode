package leetcode;

import util.ListNode;

/**
 * Created by zsc on 2018/9/26.
 * 两数相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        System.out.println(solution2.addTwoNumbers(l1,l2).val);

    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1;
        int num2;
        int sum;
        int up = 0;
        ListNode tempResult = new ListNode(1);
        ListNode result = tempResult;
        while (l1 != null || l2 != null){
            num1 = l1 != null ? l1.val : 0;
            num2 = l2 != null ? l2.val : 0;
            sum = num1 + num2 + up;
            up = sum / 10;
            tempResult.next = new ListNode(sum % 10);
            tempResult = tempResult.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (up > 0) {
            tempResult.next = new ListNode(up);
        }
        return result.next;
    }
}

