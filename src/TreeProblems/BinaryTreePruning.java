package TreeProblems;

public class BinaryTreePruning
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution solution = new Solution();

        printTree(solution.pruneTree(root));
    }

    private static void printTree(TreeNode root)
    {
        if (root == null) return;

        System.out.println(root.val);

        printTree(root.left);
        printTree(root.right);

    }

    private static class Solution
    {
        public TreeNode pruneTree(TreeNode root)
        {
            if (root == null) return null;
            if (root.left == null && root.right == null)
            {
                if (root.val == 1) return root;
                else return null;
            }

            TreeNode left = pruneTree(root.left);
            TreeNode right = pruneTree(root.right);

            root.left = left;
            root.right = right;

            if (root.left == null && root.right == null && root.val == 0) return null;
            return root;
        }
    }

}
