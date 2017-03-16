package leetcode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zsc on 2017/3/14.
 * 过程：
 * 1.维护一个栈stack和一个当前结点node。初始时将node赋值为根节点。
 * 2.将当前节点node的左子链上的节点逐个推入栈中，直到没有左儿子。
 * 3.取出栈顶的节点，访问该节点，将当前节点node赋值为该节点的右儿子。
 * 4.不断执行 2，3，直到栈为空且当前节点也为空。
 * 跟前序遍历的非递归实现方法二很类似。唯一的不同是访问当前节点的时机：前序遍历在入栈前访问，而中序遍历在出栈后访问。
 */

public class BinaryTreeInorderTraversal2 {
    public static void main(String[] args) {
        TreeNode Tree99 = new TreeNode(1);
        Tree99.left = new TreeNode(2);
        Tree99.right = new TreeNode(3);
        Tree99.left.left = new TreeNode(4);
        List result = new Solution99_2().inorderTraversal(Tree99);
        System.out.println(result);
    }
}

class Solution99_2 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
