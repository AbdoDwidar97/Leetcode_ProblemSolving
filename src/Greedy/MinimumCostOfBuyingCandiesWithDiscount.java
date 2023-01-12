package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class MinimumCostOfBuyingCandiesWithDiscount
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.minimumCost(new int[]{6,5,7,9,2,2}));
    }

    private static class Solution
    {
        public int minimumCost(int[] cost)
        {
            int minCost = 0;
            Arrays.sort(cost);

            int numOfCandies = 0;
            for (int i = cost.length - 1; i >= 0; i--)
            {
                if (numOfCandies == 2) numOfCandies = 0;
                else
                {
                    minCost += cost[i];
                    numOfCandies++;
                }
            }

            return minCost;
        }
    }

}
