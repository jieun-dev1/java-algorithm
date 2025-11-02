package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestZigZagPath {


    public int longestZigZag(TreeNode root) {
        return Math.max(
                dfs(true, root, 0),
                dfs(false, root, 0)
        );
    }

    public int dfs(Boolean wasLeft, TreeNode node, int depth) {
        if (node == null) return depth;
        if (wasLeft) {
            depth = Math.max(
            dfs(false, node.right, depth + 1),
            dfs(true, node.left, 0)
            );
        } else {
            depth = Math.max(
            dfs(true, node.left, depth + 1),
            dfs(false, node.right, 0)
            );
        }
        return depth;
    }

    public static void main(String[] args) {
        LongestZigZagPath zigZagPath = new LongestZigZagPath();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);
        System.out.println(zigZagPath.longestZigZag(root));
    }
}
