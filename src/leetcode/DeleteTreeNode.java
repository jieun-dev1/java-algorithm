package leetcode;

public class DeleteTreeNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            int min = getMin(root.right);
            System.out.println("min:"+min);
            root.val = min;
            root.right = deleteNode(root.right, min);
        }
        return root;
    }

    public int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
