package TreeProblems;

import java.util.ArrayList;

public class CountNodesEqualToAverageOfSubtree
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(8);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(6);

        Solution solution = new Solution();

        int res = solution.averageOfSubtree(root);

        System.out.println(res);
    }

    private static class Solution
    {
        private ArrayList<Integer> nodesNumbers = new ArrayList<>();
        public int averageOfSubtree(TreeNode root)
        {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;

            int numberNode = 0;
            nodesNumbers.clear();
            storeNodesNumbers(root);

            int avg = nodesNumbers.stream().reduce(Integer::sum).get() / nodesNumbers.size();
            if (avg == root.val) numberNode++;

            int left = averageOfSubtree(root.left);
            int right = averageOfSubtree(root.right);

            return left + right + numberNode;
        }

        private void storeNodesNumbers(TreeNode root)
        {
            if (root == null) return;

            nodesNumbers.add(root.val);

            if (root.left == null && root.right == null) return;

            storeNodesNumbers(root.left);
            storeNodesNumbers(root.right);
        }
    }
}
