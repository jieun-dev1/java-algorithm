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

import java.util.*;
public class ZigZag {
    List<List<Integer>> answers = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return answers;
        bfs(root);
        return answers;
    }

    public void bfs(TreeNode root){
        Boolean forward = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int queueSize = queue.size(); //it can change.
            LinkedList<Integer> levels = new LinkedList<>();
            for (int i=0; i<queueSize; i++){
                TreeNode node = queue.poll();
                if (forward) {
                    levels.addLast(node.val);
                } else {
                    levels.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            forward = !forward;
            answers.add(levels);
        }

    }
}