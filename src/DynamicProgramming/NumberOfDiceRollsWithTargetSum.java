package DynamicProgramming;

public class NumberOfDiceRollsWithTargetSum
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.numRollsToTarget(1, 6, 3));
        System.out.println(solution.numRollsToTarget(2, 6, 7));
        System.out.println(solution.numRollsToTarget(30, 30, 500));
    }

    private static class Solution
    {
        public int numRollsToTarget(int n, int k, int target)
        {
            int numOdWays = 0;

            if (n == 0 && target == 0) return 1;
            if (n == 0) return 0;

            for (int i = 1; i <= k; i++)
            {
                numOdWays += numRollsToTarget(n - 1, k, target - i);
            }

            return numOdWays;
        }
    }
}
