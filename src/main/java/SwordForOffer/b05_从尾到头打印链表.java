package SwordForOffer;

import util.ListNode;

import java.util.LinkedList;

/**
 * Created by zsc on 2017/3/16.
 * 反向打印链表
 *
 * 输入一个链表的头节点，从尾到头反向打印
 * 将链表存入栈中，打印
 */
public class b05_从尾到头打印链表 {

    public static void main(String args[]) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        printListReversversingly(node1);
    }

    private static void printListReversversingly(ListNode listNode) {
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }
}
