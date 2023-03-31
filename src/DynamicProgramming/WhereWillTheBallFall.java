package DynamicProgramming;

import java.util.Arrays;

public class WhereWillTheBallFall
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // int[] res = solution.findBall(new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}});
        int[] res = solution.findBall(new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}});
        Arrays.stream(res).forEach(System.out::println);
    }

    private static class Solution
    {
        public int[] findBall(int[][] grid)
        {
            int m = grid.length, n = grid[0].length;
            int[] answer = new int[n];
            int[][] dp = new int[m + 1][n];

            // Initialize DP Table
            for (int i = 0; i < m + 1; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (i == 0)
                    {
                        dp[0][j] = j;
                        answer[j] = -1;
                    }
                    else dp[i][j] = -1;
                }
            }

            // Traverse grid with DP table
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (dp[i][j] != -1)
                    {
                        int ball = dp[i][j];

                        if (
                                !((j == 0 && grid[i][j] == -1) ||
                                (j == n - 1 && grid[i][j] == 1) ||
                                (grid[i][j] == 1 && grid[i][j + 1] == -1) ||
                                (grid[i][j] == -1 && grid[i][j - 1] == 1))
                        )
                        {
                            int dir = grid[i][j];
                            dp[i + 1][j + dir] = ball;
                        }
                    }
                }
            }

            // iterate columns
            for (int i = 0; i < n; i++)
            {
                if (dp[m][i] != -1) answer[dp[m][i]] = i;
            }

            return answer;
        }
    }
}
