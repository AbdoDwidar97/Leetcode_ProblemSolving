package TreeProblems;

public class SubtreeOfAnotherTree
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        Solution solution = new Solution();
        boolean res = solution.isSubtree(root, subRoot);

        System.out.println(res);
    }

    private static class Solution
    {
        public boolean isSubtree(TreeNode root, TreeNode subRoot)
        {
            if (root == null && subRoot == null) return true;
            if (root != null && subRoot == null) return false;
            if (root == null && subRoot != null) return false;
            else if (root.left == null && root.right == null && root.val != subRoot.val) return false;
            boolean eq = false;
            if (root.val == subRoot.val)
            {
                eq = checkEquality(root, subRoot);
            }

            boolean left = isSubtree(root.left, subRoot);
            boolean right = isSubtree(root.right, subRoot);

            return left || right || eq;
        }

        private boolean checkEquality(TreeNode root, TreeNode subRoot)
        {
            if (root == null && subRoot == null) return true;
            if (root != null && subRoot == null) return false;
            if (root == null && subRoot != null) return false;
            if (root.val != subRoot.val) return false;

            boolean left = checkEquality(root.left, subRoot.left);
            boolean right = checkEquality(root.right, subRoot.right);

            return left & right;
        }
    }
}
