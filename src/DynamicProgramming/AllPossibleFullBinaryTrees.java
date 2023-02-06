package DynamicProgramming;

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
            return null;
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
