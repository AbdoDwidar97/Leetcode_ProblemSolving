package TreeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestUnivaluePath
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(5);

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);*/

        Solution solution = new Solution();
        int res = solution.longestUnivaluePath(root);

        System.out.println(res);
    }

    private static class Solution
    {
        int maxNumber = 0;
        public int longestUnivaluePath(TreeNode root)
        {
            traverse(root);
            return maxNumber;
        }

        private int traverse(TreeNode root)
        {
            if (root == null) return 0;

            int leftLength = 0, rightLength = 0;

            int left = traverse(root.left);
            int right = traverse(root.right);

            if (root.left != null && root.left.val == root.val)
            {
                leftLength = left + 1;
            }

            if (root.right != null && root.right.val == root.val)
            {
                rightLength = right + 1;
            }

            maxNumber = Math.max(maxNumber, leftLength + rightLength);
            return Math.max(leftLength, rightLength);
        }

    }
}
