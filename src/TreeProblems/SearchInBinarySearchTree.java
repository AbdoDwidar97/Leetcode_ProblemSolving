package TreeProblems;

public class SearchInBinarySearchTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode res = solution.searchBST(root, 2);

        printTree(res);
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
        public TreeNode searchBST(TreeNode root, int val)
        {
            if (root == null) return null;
            if (root.val == val) return root;

            TreeNode left = searchBST(root.left, val);
            TreeNode right = searchBST(root.right, val);

            if (left != null) return left;
            else return right;
        }
    }

}
