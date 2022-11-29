package TreeProblems;

public class MaximumDepthOfBinaryTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int res = solution.maxDepth(root);
        System.out.println(res);
    }

    private static class Solution
    {
        public int maxDepth(TreeNode root)
        {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            return Math.max(left, right) + 1;
        }
    }
}
