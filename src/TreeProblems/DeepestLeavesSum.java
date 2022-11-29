package TreeProblems;

public class DeepestLeavesSum
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.left = new TreeNode(7);

        root.right.right = new TreeNode(6);

        root.right.right.right = new TreeNode(8);

        Solution solution = new Solution();

        int res = solution.deepestLeavesSum(root);

        System.out.println(res);
    }

    private static class Solution
    {
        int maxLevel = 0;
        int totalSum = 0;
        public int deepestLeavesSum(TreeNode root)
        {
            traceLeaves(root, 0);
            return totalSum;
        }

        private void traceLeaves(TreeNode root, int level)
        {
            if (root == null) return;
            if (root.left == null && root.right == null)
            {
                if (level > maxLevel)
                {
                    maxLevel = level;
                    totalSum = root.val;
                }
                else if (level == maxLevel)
                {
                    totalSum += root.val;
                }
            }

            traceLeaves(root.left, level + 1);
            traceLeaves(root.right, level + 1);
        }
    }
}
