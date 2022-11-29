package TreeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageOfLevelsInBinaryTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);

        /*root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/

        List<Double> res = solution.averageOfLevels(root);

        res.forEach(System.out::println);
    }

    private static class Solution
    {
        List<List<Long>> levels = new ArrayList<>();
        public List<Double> averageOfLevels(TreeNode root)
        {
            List<Double> averages = new ArrayList<>();
            preOrder(root, 0);

            for (List<Long> level : levels)
            {
                averages.add(level.stream().reduce(Long::sum).get().doubleValue() / level.size());
            }

            return averages;
        }

        private void preOrder(TreeNode root, int levelIdx)
        {
            if (root == null) return;

            if (levelIdx < levels.size())
            {
                levels.get(levelIdx).add((long) root.val);
            }
            else {
                levels.add(new ArrayList<>(List.of((long) root.val)));
            }

            // levels.add(root.val);

            preOrder(root.left, levelIdx+ 1);
            preOrder(root.right, levelIdx + 1);
        }
    }
}
