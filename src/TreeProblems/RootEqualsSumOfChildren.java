package TreeProblems;

public class RootEqualsSumOfChildren
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);

        RootSolution solution = new RootSolution();
        boolean sl = solution.checkTree(root);
        System.out.println(sl);
    }
}

class RootSolution
{
    public boolean checkTree(TreeNode root)
    {
        if (root.left == null && root.right == null) return true;

        boolean left = checkTree(root.left);
        boolean right = checkTree(root.right);

        return (root.left.val + root.right.val == root.val) & left & right;
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}