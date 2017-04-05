package util;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zsc on 2017/4/1.
 */
public class TreeNode {
    public int value;
    public List<TreeNode> children = new LinkedList<>();

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
