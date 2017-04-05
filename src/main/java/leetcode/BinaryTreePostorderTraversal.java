package leetcode;

import util.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2016/3/1.
 * 递归后序遍历
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode Tree145 = new BinaryTreeNode(8);
        Tree145.left = new BinaryTreeNode(2);
        Tree145.right = new BinaryTreeNode(3);
        Tree145.left.left = new BinaryTreeNode(4);
        List result = new Solution145().postorderTraversal(Tree145);
        System.out.println(result);
    }
}

class Solution145 {
    public ArrayList<Integer> postorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public void helper(BinaryTreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            helper(root.right, list);
            list.add(root.value);
        }
    }
}


