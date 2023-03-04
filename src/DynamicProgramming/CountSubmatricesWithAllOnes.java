package DynamicProgramming;

public class CountSubmatricesWithAllOnes
{

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.numSubmat(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
        System.out.println(solution.numSubmat(new int[][]{{0,0,0},{0,0,0},{0,1,1},{1,1,0},{0,1,1}}));
    }

    private static class Solution
    {
        public int numSubmat(int[][] mat)
        {
            int result = 0;
            for (int row = 0; row < mat.length; row++)
            {
                for (int col = 0; col < mat[0].length; col++)
                {
                    if (mat[row][col] != 0) result += countRecs(mat, row, col, mat[0].length - 1);
                }
            }

            return result;
        }

        private int countRecs(int[][] mat, int x, int y, int endColIdx)
        {
            int count = 0;
            for (int row = x; row < mat.length; row++)
            {
                for (int col = y; col <= endColIdx; col++)
                {
                    if (mat[row][col] == 1) count++;
                    else if (col > y) endColIdx = col - 1;
                    else return count;
                }
            }

            return count;
        }
    }
}
