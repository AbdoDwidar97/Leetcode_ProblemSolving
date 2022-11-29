package TreeProblems;

public class BalancedBinaryTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        // ----------------------------------------------


        TreeNode root2 = new TreeNode(1);

        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        root2.right.left = new TreeNode(6);

        root2.left.left.left = new TreeNode(8);

        System.out.println(solution.isBalanced(root2));
    }

    private static class Solution
    {
        public boolean isBalanced(TreeNode root)
        {
            if (root == null) return true;
            int res = checkBalanceTree(root, 0);
            return (res != -1);
        }

        private int checkBalanceTree(TreeNode root, int level)
        {
            if (root == null) return level - 1;
            if (root.left == null && root.right == null) return level;

            int left = checkBalanceTree(root.left, level + 1);
            int right = checkBalanceTree(root.right, level + 1);

            int myLeftLength = left - level;
            int myRightLength = right - level;

            if (left == -1 || right == -1) return -1;
            else if (Math.abs(myLeftLength - myRightLength) <= 1) return Math.max(left, right);
            else return -1;
        }
    }

}
