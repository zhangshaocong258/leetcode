package leetcode;

import util.TreeNode;

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
        TreeNode Tree144 = new TreeNode(1);
        Tree144.left = new TreeNode(2);
        Tree144.right = new TreeNode(3);
        Tree144.left.left = new TreeNode(4);
        List result = new Solution144_2().preorderTraversal(Tree144);
        System.out.println(result);
    }
}

class Solution144_2 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
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

