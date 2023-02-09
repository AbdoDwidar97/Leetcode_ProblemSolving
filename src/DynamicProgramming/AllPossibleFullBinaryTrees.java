package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees
{
    public static void main(String[] args)
    {
        /// we should solve this by recursion ...
    }

    private static class Solution
    {
        public List<TreeNode> allPossibleFBT(int n)
        {
            TreeNode[] table = new TreeNode[n + 1];

            return null;
        }

        private List<TreeNode> createTrees(TreeNode root, TreeNode[] table, List<TreeNode> trees, int n)
        {
            /// First, we should copy Root tree
            TreeNode myRoot = copyTree(root);

            /// Second, we should make a new root node belongs to n level, and then, fill left and right of this node, by recursion. // EX:
            TreeNode myNodeRoot = new TreeNode(0);

            /// we must have List<TreeNode> for all possible trees according n level. // EX:
            List<TreeNode> myRootPossibleList = new ArrayList<>();

            int remain = n - 1;
            int leftNum = 1, rightNum = remain - leftNum;

            while (leftNum <= rightNum)
            {
                if (table[leftNum] == null) continue; /// ----
                if (table[rightNum] == null) continue; /// ----

                leftNum += 2;
                rightNum -= 2;
            }

            return trees;
        }

        private TreeNode copyTree(TreeNode root)
        {
            if (root == null) return null;

            TreeNode myRoot = new TreeNode(root.val);

            if (root.left == null && root.right == null) return myRoot;

            myRoot.left = copyTree(root.left);
            myRoot.right = copyTree(root.right);

            return myRoot;
        }
    }

    private static class TreeNode
    {
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
