package TreeProblems;

public class RangeSumOfBST
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);

        Solution938 solution = new Solution938();

        int res = solution.rangeSumBST(root, 7, 15);

        System.out.println(res);
    }
}

class Solution938
{
    public int rangeSumBST(TreeNode root, int low, int high)
    {
        int sum = 0;
        if (root == null) return 0;
        if (root.val >= low && root.val <= high) sum = root.val;

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        return left + right + sum;
    }
}