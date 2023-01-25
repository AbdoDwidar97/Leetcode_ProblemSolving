package DynamicProgramming;

import java.util.Arrays;

public class CountingBits
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] res = solution.countBits(5);
        Arrays.stream(res).forEach(System.out::println);
    }

    private static class Solution
    {
        public int[] countBits2(int n)
        {
            int[] ans = new int[n + 1];

            for (int i = 0; i <= n; i++)
            {
                char[] bin = Integer.toBinaryString(i).toCharArray();
                int countOnes = 0;
                for (char chr : bin)
                {
                    if (chr == '1') countOnes++;
                }

                ans[i] = countOnes;
            }

            return ans;
        }

        /// ------------------ Super sonic solution - DP with Bit-manipulation
        public int[] countBits(int n)
        {
            int[] ans = new int[n + 1];
            for (int i = 0; i <= n; i++)
            {
                if (i == 0) ans[i] = 0;
                else if (i == 1) ans[i] = 1;
                else ans[i] = -1;
            }

            for (int i = 0; i <= n; i++)
            {
                if (ans[i] == -1) ans[i] = count(ans, i);
            }

            return ans;
        }

        private int count(int[] ans, int num)
        {
            if (ans[num] == -1)
            {
                int cnt = count(ans, num >> 1);
                ans[num] = cnt + (num & 1);
            }

            return ans[num];
        }
    }
}
