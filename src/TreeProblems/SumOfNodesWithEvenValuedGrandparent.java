package TreeProblems;

import java.util.ArrayList;

public class SumOfNodesWithEvenValuedGrandparent
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(7);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        root.left.left.left = new TreeNode(9);

        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        root.right.right.right = new TreeNode(5);

        Solution solution = new Solution();

        // int res = solution.sumEvenGrandparent(root);
        int res = solution.sumEvenGrandparent2(root);
        System.out.println(res);
    }

    private static class Solution
    {
        private int totalSum = 0;
        public int sumEvenGrandparent(TreeNode root)
        {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 0;

            traverseTree(root);

            return totalSum;
        }

        private void traverseTree(TreeNode root)
        {
            if (root == null) return;
            if (root.left == null && root.right == null) return;

            if (root.val % 2 == 0) checkForGrandChildren(root, 0);

            traverseTree(root.left);
            traverseTree(root.right);
        }

        private void checkForGrandChildren(TreeNode root, int level)
        {
            if (root == null) return;

            if (level == 2) totalSum += root.val;

            if (root.left == null && root.right == null) return;

            checkForGrandChildren(root.left, level + 1);
            checkForGrandChildren(root.right, level + 1);
        }

        // --------------------------Smart way-----------------------------------------

        public int sumEvenGrandparent2(TreeNode root)
        {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 0;
            checkForGrandChildren2(root, null, null);
            return totalSum;
        }

        private void checkForGrandChildren2(TreeNode root, TreeNode parent, TreeNode grand)
        {
            if (root == null) return;
            if (grand != null && grand.val % 2 == 0) totalSum += root.val;

            checkForGrandChildren2(root.left, root, parent);
            checkForGrandChildren2(root.right, root, parent);
        }
    }
}
