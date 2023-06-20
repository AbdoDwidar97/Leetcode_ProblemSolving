package Challenge.d1;

public class S1
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(solution.maxArea(new int[]{2,3,4,5,18,17,6}));
    }

    private static class Solution
    {
        public int maxArea2(int[] height)
        {
            return dfs(height, 0, new int[height.length]);
        }

        private int dfs(int[] height, int i, int[] dp)
        {
            if (i >= height.length) return 0;
            if (dp[i] == 0)
            {
                int maxArea = 0;
                for (int next = i + 1; next < height.length; next++)
                {
                    maxArea = Math.max(maxArea, Math.max(calcArea(height, i, next), dfs(height, next, dp)));
                }

                dp[i] = maxArea;
            }

            return dp[i];
        }

        private int calcArea(int[] height, int l1, int l2)
        {
            return (l2 - l1) * Math.min(height[l1], height[l2]);
        }

        /// another solution
        public int maxArea(int[] height)
        {
            int p1 = 0, p2 = height.length - 1;
            int maxArea = 0;

            while (p1 < p2)
            {
                if (height[p1] < height[p2])
                {
                    maxArea = Math.max(maxArea, height[p1] * (p2 - p1));
                    p1++;
                }
                else
                {
                    maxArea = Math.max(maxArea, height[p2] * (p2 - p1));
                    p2--;
                }
            }

            return maxArea;
        }
    }

}
