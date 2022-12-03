package Graphs;

public class MaximumTotalImportanceOfRoads
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}}));
    }

    private static class Solution
    {
        public long maximumImportance(int n, int[][] roads)
        {
            /// solution here ...
            return Long.MAX_VALUE;
        }
    }
}
