package Challenge.d3;

public class JumpGameII
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
        System.out.println(solution.jump(new int[]{2,3,0,1,4}));
    }

    private static class Solution
    {
        public int jump(int[] nums)
        {
            int[] dp = new int[nums.length];
            return dfsMemoization(nums, 0, dp);
        }

        private int dfsMemoization(int[] nums, int pos, int[] dp)
        {
            if (pos >= nums.length - 1) return 0;
            if (dp[pos] == Integer.MAX_VALUE) return dp[pos];
            if (dp[pos] == 0)
            {
                if (nums[pos] == 0)
                {
                    dp[pos] = Integer.MAX_VALUE;
                    return dp[pos];
                }

                int itr = nums[pos];
                int minValue = Integer.MAX_VALUE;
                int limit = Math.min(pos + itr + 1, nums.length);
                for (int i = pos + 1; i < limit; i++)
                {
                    minValue = Math.min(minValue, dfsMemoization(nums, i, dp));
                }

                dp[pos] = minValue;
            }

            return dp[pos] + 1;
        }
    }
}
