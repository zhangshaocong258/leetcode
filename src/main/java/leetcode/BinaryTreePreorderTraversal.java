package leetcode;

import util.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2016/3/1.
 * 递归先序遍历
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode Tree144 = new BinaryTreeNode(6);
        Tree144.left = new BinaryTreeNode(2);
        Tree144.right = new BinaryTreeNode(3);
        Tree144.left.left = new BinaryTreeNode(4);
        List result = new Solution144().preorderTraversal(Tree144);
        System.out.println(result);
    }

    //用于输出二叉树先序遍历
    public static ArrayList<Integer> preorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public static void helper(BinaryTreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.value);
            helper(root.left, list);
            helper(root.right, list);
        }
    }
}

class Solution144 {
    public ArrayList<Integer> preorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public void helper(BinaryTreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.value);
            helper(root.left, list);
            helper(root.right, list);
        }
    }
}



