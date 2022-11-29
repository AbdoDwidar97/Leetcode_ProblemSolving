package TreeProblems;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        int res = solution.sumRootToLeaf(root);

        System.out.println(res);
    }

    private static class Solution
    {
        public int sumRootToLeaf(TreeNode root)
        {
            return traceForCode(root, "");
        }

        private int traceForCode(TreeNode root, String code)
        {
            if (root == null) return 0;
            if (root.left == null && root.right == null)
            {
                code = code.concat(String.valueOf(root.val));
                return Integer.parseInt(code, 2);
            }

            int left = traceForCode(root.left, code.concat(String.valueOf(root.val)));
            int right = traceForCode(root.right, code.concat(String.valueOf(root.val)));

            return left + right;
        }
    }
}
