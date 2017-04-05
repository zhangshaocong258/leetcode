package leetcode;

import util.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2016/3/1.
 * 递归中序遍历
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode Tree99 = new BinaryTreeNode(1);
        Tree99.left = new BinaryTreeNode(2);
        Tree99.right = new BinaryTreeNode(3);
        Tree99.left.left = new BinaryTreeNode(4);
        List result = new Solution99().inorderTraversal(Tree99);
        System.out.println(result);

    }

    //用于输出二叉树终须遍历
    public static ArrayList<Integer> inorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public static void helper(BinaryTreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            list.add(root.value);
            helper(root.right, list);
        }
    }
}

class Solution99 {
    public ArrayList<Integer> inorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public void helper(BinaryTreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            list.add(root.value);
            helper(root.right, list);
        }
    }
}


