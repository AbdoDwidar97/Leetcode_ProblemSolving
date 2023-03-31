package DynamicProgramming;

import java.util.Arrays;

public class PartitionArrayForMaximumSum
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println("Result: " + solution.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }

    private static class Solution
    {
        public int maxSumAfterPartitioning(int[] arr, int k)
        {
            int n = arr.length;
            int[] table = new int[n];
            return dfs(arr, table, 0, k);
        }

        private int dfs(int[] arr, int[] table, int current, int k)
        {
            if (current >= table.length) return 0;
            if (table[current] != 0) return table[current];

            int lngth = Math.min(table.length, current + k);
            int maxElement = arr[current];
            int maxSum = 0;
            for (int i = current; i < lngth; i++)
            {
                maxElement = Math.max(maxElement, arr[i]);
                maxSum = Math.max(maxSum, maxElement * (i - current + 1) + dfs(arr, table, i + 1, k));
            }

            table[current] = maxSum;
            return table[current];
        }
    }
}
