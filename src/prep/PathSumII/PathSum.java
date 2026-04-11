package prep.PathSumII;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
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

        List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum, new ArrayList<>(), 0);
            return answer;
        }

        public void dfs(TreeNode root, int targetSum, List<Integer> current, int currentSum) {
            if (root == null){
                return;
            }
            currentSum += root.val;
            current.add(root.val);
            //when it's a leaf node,
            if (root.left == null && root.right == null) {
                if (targetSum == currentSum) {
                    answer.add(new ArrayList<>(current)); //copy and paste it
                    //answer.add(current); //현재 모든 재귀에서 같은 list<Integer> used. if I save this one, part of it will be removed as well and ended up empty list. x
                }
            } else {
                dfs(root.left, targetSum, current, currentSum);
                dfs(root.right, targetSum, current, currentSum);
            }
            current.removeLast();
        }
}
