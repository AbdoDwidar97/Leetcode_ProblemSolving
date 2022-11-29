package Matrix;

public class LargestLocalValuesInMatrix
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] res = solution.largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}});

        for (int i = 0; i < res.length; i++)
        {
            for (int j = 0; j < res[0].length; j++)
            {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static class Solution
    {
        public int[][] largestLocal(int[][] grid)
        {
            for (int y = 3; y < grid.length; y++)
            {
                for (int x = 3; x < grid[0].length; x++)
                {

                }
            }

            return null;
        }

        private int getMaxValue(int[][] grid)
        {
            return 0;
        }
    }
}
