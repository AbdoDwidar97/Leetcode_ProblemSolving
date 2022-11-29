package TreeProblems;

public class BinarySearchTreeToGreaterSumTree
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.right.right.right = new TreeNode(8);

        Solution solution = new Solution();

        TreeNode res = solution.bstToGst(root);

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
        private int sum = 0;
        public TreeNode bstToGst(TreeNode root)
        {
            if (root == null) return null;
            if (root.left == null && root.right == null)
            {
                root.val += sum;
                sum = root.val;
                return root;
            }

            TreeNode right = bstToGst(root.right);

            root.val += sum;
            sum = root.val;

            TreeNode left = bstToGst(root.left);

            root.left = left;
            root.right = right;

            return root;
        }
    }
}
