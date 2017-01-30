package leetcode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2016/3/1.
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode Tree99 = new TreeNode(1);
        Tree99.left = new TreeNode(2);
        Tree99.right = new TreeNode(3);
        Tree99.left.left = new TreeNode(4);
        List result = new Solution99().inorderTraversal(Tree99);
        System.out.println(result);
    }
}

class Solution99 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }
}


