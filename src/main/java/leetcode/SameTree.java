package leetcode;

/**
 * Created by zsc on 2016/3/1.
 */

import util.BinaryTreeNode;

/**
 * Definition for a binary tree node.
 * public class BinaryTreeNode {
 * int value;
 * BinaryTreeNode left;
 * BinaryTreeNode right;
 * BinaryTreeNode(int x) { value = x; }
 * }
 */
public class SameTree {
    public static void main(String[] args) {
        BinaryTreeNode Tree1 = new BinaryTreeNode(2);
        Tree1.left = new BinaryTreeNode(2);
        Tree1.right = new BinaryTreeNode(2);
        Tree1.left.left = new BinaryTreeNode(2);

        BinaryTreeNode Tree2 = new BinaryTreeNode(2);
        Tree2.left = new BinaryTreeNode(2);
        Tree2.right = new BinaryTreeNode(2);
        Tree2.left.left = new BinaryTreeNode(2);
        Tree2.right.left = new BinaryTreeNode(2);
        boolean result = new Solution100().isSameTree(Tree1, Tree2);
        System.out.println(result);
    }
}

class Solution100 {
    public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        if (p.value == q.value) {
            BinaryTreeNode p_left = p.left;
            BinaryTreeNode q_left = q.left;
            BinaryTreeNode p_right = p.right;
            BinaryTreeNode q_right = q.right;
            return isSameTree(p_left, q_left) && isSameTree(p_right, q_right);
        } else {
            return false;
        }
    }
}

