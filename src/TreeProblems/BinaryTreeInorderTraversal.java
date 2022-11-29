package TreeProblems;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = solution.inorderTraversal(root);

        res.forEach(System.out::println);
    }

    private static class Solution
    {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root)
        {
            inOrder(root);
            return list;
        }

        private void inOrder(TreeNode root)
        {
            if (root == null) return;
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }
    }
}
