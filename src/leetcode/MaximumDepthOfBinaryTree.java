package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = leaft;
 * this.right = right;
 * }
 * }
 */
class MaximumDepthOfBinaryTree {
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }

    }
}
