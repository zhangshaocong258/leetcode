package SwordForOffer;

import util.BinaryTreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zsc on 2017/8/27.
 * 【解】：与23题 "d23_从上往下打印二叉树"类似
 *      用一个队列来保存将要打印的结点。
 *      为了把二叉树的每一行单独打印到一行里，我们需要两个变量：
 *      - current：表示在当前的层中还没有打印的结点数
 *      - next：表示下一层结点的数目
 *      用sortList保存当前行的数据，最后排序输出
 */
public class h60_把二叉树打印成多行 {
    //                       1
    //                2             3
    //             4      5      6      7
    //          8     9
    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(3);
        BinaryTreeNode n3 = new BinaryTreeNode(2);
        BinaryTreeNode n4 = new BinaryTreeNode(7);
        BinaryTreeNode n5 = new BinaryTreeNode(6);
        BinaryTreeNode n6 = new BinaryTreeNode(5);
        BinaryTreeNode n7 = new BinaryTreeNode(4);
        BinaryTreeNode n8 = new BinaryTreeNode(9);
        BinaryTreeNode n9 = new BinaryTreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        print(n1);
    }

    private static void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        List<BinaryTreeNode> list = new LinkedList<BinaryTreeNode>();
        List<Integer> sortList = new LinkedList<Integer>();
        BinaryTreeNode node;
        int current = 1;     // 当前层的结点个数
        int next = 0;   // 记录下一层的结点个数
        list.add(root);
        while (list.size() > 0) {
            node = list.remove(0);
            sortList.add(node.value);
            current--;
            if (node.left != null) {
                list.add(node.left);
                next++;
            }
            if (node.right != null) {
                list.add(node.right);
                next++;
            }
            if (current == 0) {
                //排序或者不排序
                Collections.sort(sortList);
                for (int i = 0; i < sortList.size(); i++) {
                    System.out.print(sortList.get(i) + "\t");
                }
                System.out.println();
                sortList.clear();
                current = next;
                next = 0;
            }
        }
    }
}
