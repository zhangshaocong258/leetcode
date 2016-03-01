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


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution{
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
public class MaximumDepthofBinaryTree {
    public static void main(String args []){
        TreeNode Tree = new TreeNode(2);
        Tree.left = new TreeNode(2);
        Tree.right = new TreeNode(2);
        Tree.left.left = new TreeNode(2);
        int depth = new Solution().maxDepth(Tree);
        System.out.println(depth);
    }
}


