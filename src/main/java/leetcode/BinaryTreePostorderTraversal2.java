package leetcode;

import util.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zsc on 2017/8/31.
 */
public class BinaryTreePostorderTraversal2 {
    public static void main(String[] args) {
        BinaryTreeNode Tree145 = new BinaryTreeNode(8);
        Tree145.left = new BinaryTreeNode(2);
        Tree145.right = new BinaryTreeNode(3);
        Tree145.left.left = new BinaryTreeNode(4);
        List result = new Solution145_2().postorderTraversal(Tree145);
        System.out.println(result);
    }
}

class Solution145_2 {
    public ArrayList<Integer> postorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        int[] flag = new int[10000];
        BinaryTreeNode node = root;
        while (node != null) {
            stack.push(node);
            flag[stack.size()] = 0;
            node = node.left;
        }

        while (!stack.isEmpty()) {
            node = stack.peek();
            while (flag[stack.size()] == 0 && node.right != null) {
                node = node.right;
                flag[stack.size()] = 1;
                while (node != null) {
                    stack.push(node);
                    flag[stack.size()] = 0;
                    node = node.left;
                }
                node = stack.peek();
            }
            node = stack.pop();
            list.add(node.value);
        }
        return list;
    }

}

