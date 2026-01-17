package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode lastElement = null;
            for (int i=0; i<size; i++) {
                TreeNode element = queue.poll();
                if (element == null) continue;
                if (element.left != null) queue.offer(element.left);
                if (element.right != null) queue.offer(element.right);
                lastElement = element;
            }
            answer.add(lastElement.val);
        }
        return answer;
    }
}