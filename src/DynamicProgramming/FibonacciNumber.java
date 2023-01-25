package DynamicProgramming;

public class FibonacciNumber
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.fib(4));
    }

    private static class Solution
    {
        public int fib(int n)
        {
            int[] table = new int[n + 1];

            for (int i = 0; i <= n; i++)
            {
                if (i == 0) table[0] = 0;
                else if (i == 1) table[1] = 1;
                else table[i] = -1;
            }

            return dfsFib(table, n);
        }

        private int dfsFib(int[] table, int num)
        {
            if (table[num] == -1)
                table[num] = dfsFib(table, num - 1) + dfsFib(table, num - 2);

            return table[num];
        }
    }
}
