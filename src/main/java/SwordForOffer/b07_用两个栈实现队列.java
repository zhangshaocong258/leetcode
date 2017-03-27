package SwordForOffer;

import java.util.Stack;

/**
 * Created by zsc on 2017/3/16.
 * 用两个栈实现队列
 */
public class b07_用两个栈实现队列 {

    private static Stack<String> stack1 = new Stack<String>();
    private static Stack<String> stack2 = new Stack<String>();
    public static void main(String args[]) throws Exception{
        appendTail("a");
        appendTail("b");
        appendTail("c");
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());
    }

    private static void appendTail(String s) {
        stack1.push(s);
    }

    private static String deleteHead() throws Exception{
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new Exception("队列为空，不能删除");
        }

        return stack2.pop();
    }
}
