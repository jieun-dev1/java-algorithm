package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//월요일에 다시 보기
public class LongestZigZagPath {

    int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(true, root, 0);
        dfs(false, root, 0);
        return maxLength;
    }

    public void dfs(boolean wasLeft, TreeNode node, int depth) {
        if (node == null) return;
        dfs(true, node.left, wasLeft ? 1 : depth+1);
        dfs(false, node.right, wasLeft ? depth + 1 : 1);

        maxLength = Math.max(depth, maxLength);
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
