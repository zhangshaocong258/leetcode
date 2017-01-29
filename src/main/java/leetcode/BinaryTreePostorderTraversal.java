package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsc on 2016/3/1.
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode Tree145 = new TreeNode(8);
        Tree145.left = new TreeNode(2);
        Tree145.right = new TreeNode(3);
        Tree145.left.left = new TreeNode(4);
        List result = new Solution145().postorderTraversal(Tree145);
        System.out.println(result);
    }
}

class Solution145 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            helper(root.right, list);
            list.add(root.val);
        }
    }
}


