package leetcode;

/**
 * Created by zsc on 2016/3/1.
 */
/* Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args ){
        TreeNode Tree104 = new TreeNode(2);
        Tree104.left = new TreeNode(2);
        Tree104.right = new TreeNode(2);
        Tree104.left.left = new TreeNode(2);
        int depth = new Solution104().maxDepth(Tree104);
        System.out.println(depth);
    }
}

class Solution104{
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int depth) {
        if (node == null)
            return depth;
        int left=helper(node.left,depth+1);
        int right=helper(node.right,depth+1);
        return Math.max(left,right);
    }
}




