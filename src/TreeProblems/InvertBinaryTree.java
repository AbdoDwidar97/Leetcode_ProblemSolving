package TreeProblems;

public class InvertBinaryTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        printTree(solution.invertTree(root));
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
        public TreeNode invertTree(TreeNode root)
        {
            if (root == null) return null;
            if (root.left == null && root.right == null) return root;

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;
        }
    }
}
