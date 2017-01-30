package leetcode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2016/3/1.
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode Tree144 = new TreeNode(6);
        Tree144.left = new TreeNode(2);
        Tree144.right = new TreeNode(3);
        Tree144.left.left = new TreeNode(4);
        List result = new Solution144().preorderTraversal(Tree144);
        System.out.println(result);
    }
}

class Solution144 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);
            helper(root.left, list);
            helper(root.right, list);
        }
    }
}



