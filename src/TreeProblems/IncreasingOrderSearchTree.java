package TreeProblems;

import java.util.ArrayList;

public class IncreasingOrderSearchTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);

        TreeNode res = solution.increasingBST(root);
        printTree(res);
    }

    private static void printTree(TreeNode result)
    {
        while (result != null)
        {
            System.out.println(result.val);
            result = result.right;
        }
    }

    private static class Solution
    {
        ArrayList<TreeNode> list = new ArrayList<>();
        public TreeNode increasingBST(TreeNode root)
        {
            inOrderTree(root);

            for (int i = 0; i < list.size() - 1; i++)
            {
                list.get(i).right = list.get(i + 1);
                list.get(i).left = null;
            }

            return list.get(0);
        }

        private void inOrderTree(TreeNode root)
        {
            if (root == null) return;

            inOrderTree(root.left);

            list.add(root);

            inOrderTree(root.right);
        }

    }
}
