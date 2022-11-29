package TreeProblems;

public class MergeTwoBinaryTrees
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
    }

    private static class Solution
    {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
        {
            TreeNode newNode = null;

            if (root1 == null && root2 == null) return null;
            else if (root1 == null && root2 != null)
            {
                newNode = new TreeNode(root2.val);

                newNode.left = mergeTrees(null, root2.left);
                newNode.right = mergeTrees(null, root2.right);
            }
            else if (root1 != null && root2 == null)
            {
                newNode = new TreeNode(root1.val);

                newNode.left = mergeTrees(root1.left, null);
                newNode.right = mergeTrees(root1.right, null);
            }
            else if (root1 != null && root2 != null)
            {
                newNode = new TreeNode(root1.val + root2.val);

                newNode.left = mergeTrees(root1.left, root2.left);
                newNode.right = mergeTrees(root1.right, root2.right);
            }

            return newNode;
        }
    }
}


