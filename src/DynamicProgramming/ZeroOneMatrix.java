package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ZeroOneMatrix
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        int[][] res = solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});

        // int[][] res = solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});

        /*int[][] res = solution.updateMatrix(new int[][]{
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}
        });*/

        // int[][] res = solution.updateMatrix(new int[][]{{0}, {1}});

        for (int[] row : res)
        {
            Arrays.stream(row).forEach(System.out::println);
            System.out.println("----");
        }
    }

    private static class Solution
    {
        public int[][] updateMatrix(int[][] mat)
        {
            int m = mat.length, n = mat[0].length;
            int[][] table = new int[m][n];

            Queue<Integer[]> unvisited = new ArrayDeque<>();

            // initialize table & unvisited queue
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (mat[i][j] != 0) table[i][j] = -1;
                    else unvisited.add(new Integer[]{i, j, 0});
                }
            }

            bfs(table, unvisited);

            return table;
        }

        private void bfs(int[][] table, Queue<Integer[]> unvisited)
        {
            while (!unvisited.isEmpty())
            {
                Integer[] currentCell = unvisited.poll();
                int row = currentCell[0], column = currentCell[1], distance = currentCell[2];

                if (table[row][column] == -1)
                    table[row][column] = distance;

                // left child
                if (column - 1 >= 0 && table[row][column - 1] == -1)
                    unvisited.add(new Integer[]{row, column - 1, distance + 1});

                // right child
                if (column + 1 < table[0].length && table[row][column + 1] == -1)
                    unvisited.add(new Integer[]{row, column + 1, distance + 1});

                // up child
                if (row - 1 >= 0 && table[row - 1][column] == -1)
                    unvisited.add(new Integer[]{row - 1, column, distance + 1});

                // down child
                if (row + 1 < table.length && table[row + 1][column] == -1)
                    unvisited.add(new Integer[]{row + 1, column, distance + 1});

            }

        }

    }
}
