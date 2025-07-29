package leetcode;


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
class MaxLevelSumBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevel = 0;
        int answerLevel = 1;
        int maxSum = root.val;

        while(!queue.isEmpty()) {
            currentLevel ++;
            int size = queue.size();
            int currentSum = 0;
            for (int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                currentSum += current.val;
                if (current.left!=null) queue.offer(current.left);
                if (current.right!=null) queue.offer(current.right);
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                answerLevel = currentLevel;
            }
        }
        return answerLevel;
    }
}