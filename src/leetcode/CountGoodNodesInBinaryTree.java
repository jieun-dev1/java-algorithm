package leetcode;

public class CountGoodNodesInBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    int answer = 1; //including root

    public int goodNodes(TreeNode root) {
        dfs(root.left, root.val);
        dfs(root.right, root.val);
        return answer;
    }

    public void dfs(TreeNode root, int max){
        if (root == null) return;
        if (root.val >= max) {
            max = root.val;
            answer += 1;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
