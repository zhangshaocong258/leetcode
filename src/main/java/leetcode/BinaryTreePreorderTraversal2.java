package leetcode;

import util.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zsc on 2016/3/13.
 */
/**
 * 分析：
 * 先序遍历先对当前节点做出访问后，然后递归的调用对儿子节点的遍历，不需要在对儿子节点遍历结束后再回过头来处理当前节点。
 * 于是模拟的递归中也不需要存储之前的调用栈信息，只需要类似的生成一个未来的儿子节点的访问计划即可。
 */
public class BinaryTreePreorderTraversal2 {
    public static void main(String[] args) {
        BinaryTreeNode Tree144 = new BinaryTreeNode(1);
        Tree144.left = new BinaryTreeNode(2);
        Tree144.right = new BinaryTreeNode(3);
        Tree144.left.left = new BinaryTreeNode(4);
        List result = new Solution144_2().preorderTraversal(Tree144);
        System.out.println(result);
    }
}

class Solution144_2 {
    public ArrayList<Integer> preorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return null;

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            list.add(node.value);
            // right node add in stack first
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }
}

