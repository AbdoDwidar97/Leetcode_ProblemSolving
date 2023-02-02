package DynamicProgramming;

public class NThTribonacciNumber
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(4));
    }

    private static class Solution
    {
        public int tribonacci(int n)
        {
            int[] table = new int[n + 1];

            for (int i = 0; i <= n; i++)
            {
                if (i == 0) table[i] = 0;
                else if (i == 1 || i == 2) table[i] = 1;
                else
                {
                    table[i] = table[i - 1] + table[i - 2] + table[i - 3];
                }
            }

            return table[n];
        }
    }
}
