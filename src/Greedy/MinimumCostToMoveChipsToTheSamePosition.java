package Greedy;

import java.util.HashMap;

public class MinimumCostToMoveChipsToTheSamePosition
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.minCostToMoveChips(new int[]{2,2,2,3,3}));
    }

    private static class Solution
    {
        public int minCostToMoveChips(int[] position)
        {
            int evens = 0, odds = 0;

            for (int chip : position)
            {
                if (chip % 2 == 0) evens++;
                else odds++;
            }

            return Math.min(evens, odds);
        }
    }
}
