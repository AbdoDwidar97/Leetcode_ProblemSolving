package TreeProblems;

public class EvaluateBooleanBinaryTree
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution2331 solution = new Solution2331();

        boolean res = solution.evaluateTree(root);
        System.out.println(res);
    }
}

class Solution2331
{
    public boolean evaluateTree(TreeNode root)
    {
        if (root.left == null && root.right == null) return root.val == 1;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) return left || right;
        else if (root.val == 3) return left && right;

        return false;
    }
}
