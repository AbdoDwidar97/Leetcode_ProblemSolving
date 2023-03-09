package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ZeroOneMatrix
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // int[][] res = solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});

        int[][] res = solution.updateMatrix(new int[][]{
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
        });

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

            // initialize table
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (mat[i][j] != 0) table[i][j] = -1;
                }
            }

            // traverse matrix
            for (int r = 0; r < m; r++)
            {
                for (int c = 0; c < n; c++)
                {
                    if (table[r][c] == -1)
                    {
                        bfsShortestDistance(mat, table, r, c);
                    }
                }
            }

            return table;
        }

        private void bfsShortestDistance(int[][] mat, int[][] table, int r, int c)
        {
            boolean[][] visited = new boolean[mat.length][mat[0].length];
            Queue<Integer[]> unvisited = new ArrayDeque<>();

            unvisited.add(new Integer[]{r, c, 0});
            visited[r][c] = true;

            int currentLevel = 0;
            int minDist = Integer.MAX_VALUE;
            while (!unvisited.isEmpty())
            {
                Integer[] cell = unvisited.poll();
                int row = cell[0], column = cell[1], dist = cell[2];

                if (currentLevel == dist)
                {
                    if (table[row][column] != -1)
                    {
                        minDist = Math.min(minDist, table[row][column] + dist);
                    }

                }else
                {
                    currentLevel = dist;
                    if (minDist != Integer.MAX_VALUE)
                    {
                        table[r][c] = minDist;
                        return;
                    }

                    if (table[row][column] != -1) minDist = table[row][column] + dist;
                }

                // left
                if (column - 1 >= 0 && !visited[row][column - 1])
                {
                    unvisited.add(new Integer[]{row, column - 1, dist + 1});
                    visited[row][column - 1] = true;
                }

                // right
                if (column + 1 < mat[0].length && !visited[row][column + 1])
                {
                    unvisited.add(new Integer[]{row, column + 1, dist + 1});
                    visited[row][column + 1] = true;
                }

                // up
                if (row - 1 >= 0 && !visited[row - 1][column])
                {
                    unvisited.add(new Integer[]{row - 1, column, dist + 1});
                    visited[row - 1][column] = true;
                }

                // down
                if (row + 1 < mat.length && !visited[row + 1][column])
                {
                    unvisited.add(new Integer[]{row + 1, column, dist + 1});
                    visited[row + 1][column] = true;
                }
            }

            if (minDist != Integer.MAX_VALUE)
            {
                table[r][c] = minDist;
            }
        }

        private int dfsShortestDistance(int[][] mat, int[][] table, int r, int c, boolean[][] visited)
        {
            if (r < 0 || r >= table.length || c < 0 || c >= table[0].length) return Integer.MAX_VALUE;

            if (visited[r][c]) return Integer.MAX_VALUE;

            visited[r][c] = true;

            if (table[r][c] == -1)
            {
                if (mat[r][c] == 0) table[r][c] = 0;
                else
                {
                    int minDist = Integer.MAX_VALUE;

                    // left
                    minDist = Math.min(minDist, dfsShortestDistance(mat, table, r, c - 1, visited));

                    // right
                    minDist = Math.min(minDist, dfsShortestDistance(mat, table, r, c + 1, visited));

                    // up
                    minDist = Math.min(minDist, dfsShortestDistance(mat, table, r - 1, c, visited));

                    // down
                    minDist = Math.min(minDist, dfsShortestDistance(mat, table, r + 1, c, visited));

                    table[r][c] = minDist + 1;
                }
            }

            visited[r][c] = false;
            return table[r][c];
        }

    }
}
