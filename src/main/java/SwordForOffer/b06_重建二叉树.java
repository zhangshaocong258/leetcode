package SwordForOffer;

import leetcode.BinaryTreeInorderTraversal;
import leetcode.BinaryTreePreorderTraversal;
import util.TreeNode;

import java.util.List;

/**
 * Created by zsc on 2017/3/16.
 * 重建二叉树
 * 递归实现
 * 前序遍历的第一个数字即父节点，此节点将中序遍历分为左子树和右子树
 * 递归即可
 */
public class b06_重建二叉树 {

    public static void main(String args[]) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = constructCore(pre, in);

        List result1 = BinaryTreePreorderTraversal.preorderTraversal(node);
        List result2 = BinaryTreeInorderTraversal.inorderTraversal(node);
        System.out.println(result1);
        System.out.println(result2);

    }

    private static TreeNode constructCore(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);//得到根节点
        int[] lPre;
        int[] lIn;
        int[] rPre;
        int[] rIn;
        int rootCount = 0;
        //得到根节点中序遍历中的位置
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootCount = i;
            }
        }
        //得到待遍历左子树的前序遍历和中序遍历数组
        lPre = new int[rootCount];
        for (int i = 0; i < rootCount; i++) {
            lPre[i] = pre[i + 1];
        }
        lIn = new int[rootCount];
        for (int i = 0; i < rootCount; i++) {
            lIn[i] = in[i];
        }

        //得到待遍历右子树的前序遍历和中序遍历数组
        rPre = new int[in.length - rootCount - 1];
        for (int i = 0; i < rPre.length; i++) {
            rPre[i] = pre[rootCount + i + 1];
        }
        rIn = new int[in.length - rootCount - 1];
        for (int i = 0; i < rPre.length; i++) {
            rIn[i] = in[rootCount + i + 1];
        }
        node.left = constructCore(lPre, lIn);
        node.right = constructCore(rPre, rIn);
        return node;
    }
}
