package leetcode;

/**
 * Created by zsc on 2016/3/1.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode Tree1 = new TreeNode(2);
        Tree1.left = new TreeNode(2);
        Tree1.right = new TreeNode(2);
        Tree1.left.left = new TreeNode(2);

        TreeNode Tree2 = new TreeNode(2);
        Tree2.left = new TreeNode(2);
        Tree2.right = new TreeNode(2);
        Tree2.left.left = new TreeNode(2);
        Tree2.right.left = new TreeNode(2);
        boolean result = new Solution100().isSameTree(Tree1,Tree2);
        System.out.println(result);
    }
}

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;
        if(p.val == q.val){
            TreeNode p_left = p.left;
            TreeNode q_left = q.left;
            TreeNode p_right = p.right;
            TreeNode q_right = q.right;
            return isSameTree(p_left, q_left) && isSameTree(p_right, q_right);
        }
        else return false;
    }
}

