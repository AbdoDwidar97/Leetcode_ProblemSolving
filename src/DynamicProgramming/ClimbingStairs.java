package DynamicProgramming;

public class ClimbingStairs
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(5));
    }

    private static class Solution
    {
        public int climbStairs(int n)
        {
            int[] table = new int[n + 1];
            table[0] = 1;
            table[1] = 1;

            return getNumOfWays(table, n);
        }

        private int getNumOfWays(int[] table, int num)
        {
            if (table[num] == 0)
            {
                table[num] = getNumOfWays(table, num - 1) + getNumOfWays(table, num - 2);
            }

            return table[num];
        }
    }
}
