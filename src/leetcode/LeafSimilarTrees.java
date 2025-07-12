package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees{
    class Solution {

        List<Integer> leaves = new ArrayList<Integer>();
        List<Integer> leaves2 = new ArrayList<Integer>();
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            //root1 기준 leaves 를 만든다. root2 의 leaves 와 비교한다.
            dfs(root1, true);
            dfs(root2, false);
            return leaves.equals(leaves2);
        }

        public void dfs(TreeNode root, Boolean ifFirst){
            if (root.left == null && root.right == null) {
                if (ifFirst) {
                    leaves.add(root.val);
                } else {
                    leaves2.add(root.val);
                }
            }
            if (root.left != null) {
                dfs(root.left);
            }
            if (root.right != null) {
                dfs(root.right);
            }
        }

    }
}
