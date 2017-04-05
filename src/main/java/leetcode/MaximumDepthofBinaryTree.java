package leetcode;

/**
 * Created by zsc on 2016/3/1.
 */
/* Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

import util.BinaryTreeNode;

/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 *     int value;
 *     BinaryTreeNode left;
 *     BinaryTreeNode right;
 *     BinaryTreeNode(int x) { value = x; }
 * }
 */
public class MaximumDepthofBinaryTree {
    public static void main(String[] args ){
        BinaryTreeNode Tree104 = new BinaryTreeNode(2);
        Tree104.left = new BinaryTreeNode(2);
        Tree104.right = new BinaryTreeNode(2);
        Tree104.left.left = new BinaryTreeNode(2);
        int depth = new Solution104().maxDepth(Tree104);
        System.out.println(depth);
    }
}

class Solution104{
    public int maxDepth(BinaryTreeNode root) {
        return helper(root, 0);
    }

    public int helper(BinaryTreeNode node, int depth) {
        if (node == null)
            return depth;
        int left=helper(node.left,depth+1);
        int right=helper(node.right,depth+1);
        return Math.max(left,right);
    }
}




