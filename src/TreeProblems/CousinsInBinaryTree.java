package TreeProblems;

public class CousinsInBinaryTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(solution.isCousins(root, 5, 4));
    }

    private static class Solution
    {
        public boolean isCousins(TreeNode root, int x, int y)
        {
            int[] xDetails = dfsGetNodeDetails(root, null, x, 0);
            int[] yDetails = dfsGetNodeDetails(root, null, y, 0);

            if (xDetails.length == 0 || yDetails.length == 0) return false;
            return (xDetails[0] == yDetails[0] && xDetails[1] != yDetails[1]);
        }

        private int[] dfsGetNodeDetails(TreeNode node, TreeNode parent, int value, int level)
        {
            if (node == null) return new int[]{};

            if (parent != null && node.val == value) return new int[]{level, parent.val};

            if (node.left == null && node.right == null) return new int[]{};

            int[] left = dfsGetNodeDetails(node.left, node, value, level + 1);
            int[] right = dfsGetNodeDetails(node.right, node, value, level + 1);

            if (left.length > 0) return left;
            else return right;
        }
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
