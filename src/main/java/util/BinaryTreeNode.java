package util;

/**
 * Created by zsc on 2017/1/29.
 */
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode(){}
    public BinaryTreeNode(int x) {
        value = x;
    }


    @Override
    public String toString() {
        return value + "";
    }
}
