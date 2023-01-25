package Matrix;

import java.util.Arrays;

public class SpiralMatrixII
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(3);
        for (int[] row : result)
        {
            Arrays.stream(row).forEach(System.out::println);
            System.out.println("-----");
        }
    }

    private static class Solution
    {
        public int[][] generateMatrix(int n)
        {
            int[][] result = new int[n][n];

            int counter = 1;

            int row = 0, col = 0;
            while (counter <= Math.pow(n, 2))
            {

                /// right direction
                while (col < n - 1 && result[row][col + 1] == 0)
                {
                    result[row][col] = counter++;
                    if (counter == Math.pow(n, 2)) return result;
                    col++;
                }

                /// down direction
                while (row < n - 1 && result[row + 1][col] == 0)
                {
                    result[row][col] = counter++;
                    if (counter == Math.pow(n, 2)) return result;
                    row++;
                }

                /// left direction
                while (col > 0 && result[row][col - 1] == 0)
                {
                    result[row][col] = counter++;
                    if (counter == Math.pow(n, 2)) return result;
                    col--;
                }

                /// up direction
                while (row > 0 && result[row - 1][col] == 0)
                {
                    result[row][col] = counter++;
                    if (counter == Math.pow(n, 2)) return result;
                    row--;
                }

            }

            return result;
        }
    }
}
