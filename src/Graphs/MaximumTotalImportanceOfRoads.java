package Graphs;

import java.util.Arrays;

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
            long result = 0;
            long itr = 1;
            long[] ranks = new long[n];

            for (int[] road : roads)
            {
                ranks[road[0]]++;
                ranks[road[1]]++;
            }

            Arrays.sort(ranks);

            for (long rank : ranks) result += rank * itr++;

            return result;
        }
    }
}
