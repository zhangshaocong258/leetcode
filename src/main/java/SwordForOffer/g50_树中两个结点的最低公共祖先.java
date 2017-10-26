package SwordForOffer;

import util.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zsc on 2017/8/28.
 * getNodePath中递归调用要有返回，否则会将list删除
 */
public class g50_树中两个结点的最低公共祖先 {
    public static void main(String[] args) {
        test01();
        System.out.println("==========");
        test02();
        System.out.println("==========");
        test03();
    }

    /**
     * 法1
     * 递归寻找两个带查询LCA(Lowest Common Ancestor )的节点p和q，当找到后，返回给它们的父亲。
     * 如果某个节点的左右子树分别包括这两个节点，那么这个节点必然是所求的解，
     * 返回该节点。否则，返回左或者右子树（哪个包含p或者q的就返回哪个）
     * 寻找树中两个结点的最低公共祖先
     * @param root 树的根结点
     * @param p1   结点1
     * @param p2   结点2
     * @return 公共结点，两个节点不存在数中，返回null，只有一个存在于数中，返回存在的节点
     */
    private static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p1, BinaryTreeNode p2) {
        if (root == null || root == p1 || root == p2) {
            return root;
        }
        BinaryTreeNode left = lowestCommonAncestor(root.left, p1, p2);
        BinaryTreeNode right = lowestCommonAncestor(root.right, p1, p2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }





    /**
     * 法2
     * 寻找树中两个结点的最低公共祖先
     *
     * @param root 树的根结点
     * @param p1   结点1
     * @param p2   结点2
     * @return 公共结点，没有返回null
     */
    private static BinaryTreeNode getLastCommonParent(BinaryTreeNode root, BinaryTreeNode p1, BinaryTreeNode p2) {
        if (root == null || p1 == null || p2 == null) {
            return null;
        }
        List<BinaryTreeNode> path1 = new LinkedList<BinaryTreeNode>();
        getNodePath(root, p1, path1);
        List<BinaryTreeNode> path2 = new LinkedList<BinaryTreeNode>();
        getNodePath(root, p2, path2);
        return getLastCommonNode(path1, path2);
    }

    /**
     * 寻找两条路径的最后一个公共结点
     *
     * @param path1
     * @param path2
     * @return 没有则返回null
     */
    private static BinaryTreeNode getLastCommonNode(List<BinaryTreeNode> path1, List<BinaryTreeNode> path2) {
        BinaryTreeNode last = null;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i) == path2.get(i)) {
                last = path1.get(i);
            } else {
                break;
            }
        }
        return last;
    }

    /**
     * 记录到达结点p的必经之路
     *
     * @param root
     * @param p
     * @param path
     */
    private static boolean getNodePath(BinaryTreeNode root, BinaryTreeNode p, List<BinaryTreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            path.add(root);
            return true;
        }
        path.add(root);
        if (getNodePath(root.left, p, path)) {
            return true;
        }
        if (getNodePath(root.right, p, path)) {
            return true;
        }
        //此路不通，原路返回
        path.remove(path.size() - 1);
        return false;
    }


    // 形状普通的树
    //              1
    //            /   \
    //          2       3
    //        /          \
    //      4             5
    //    /   \         /   \
    //   6     7       8     9
    public static void test01() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n6;
        n4.right = n7;
        n3.right = n5;
        n5.left = n8;
        n5.right = n9;
//        System.out.println(getLastCommonParent(n1, n6, n8));
        System.out.println(lowestCommonAncestor(n1, n9, n8));
    }

    // 树退化成一个链表
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test02() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;
        System.out.println(getLastCommonParent(n1, n4, n5));
    }

    // 树退化成一个链表，一个结点不在树中
    //               1
    //              /
    //             2
    //            /
    //           3
    //          /
    //         4
    //        /
    //       5
    private static void test03() {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;
        System.out.println(getLastCommonParent(n1, n5, n6));
        System.out.println(lowestCommonAncestor(n1, n7, n6));
    }
}
