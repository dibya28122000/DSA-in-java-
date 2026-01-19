class Solution {
    public int maxDepth(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Recursively find depth
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return maximum
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
