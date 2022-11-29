package Matrix;

import java.util.*;

public class Matrix
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[][] res = solution.updateMatrix3(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        /*int[][] res = solution.updateMatrix(new int[][]{{1,0,1,1,0,0,1,0,0,1},
                                                        {0,1,1,0,1,0,1,0,1,1},
                                                        {0,0,1,0,1,0,0,1,0,0},
                                                        {1,0,1,0,1,1,1,1,1,1},
                                                        {0,1,0,1,1,0,0,0,0,1},
                                                        {0,0,1,0,1,1,1,0,1,0},
                                                        {0,1,0,1,0,1,0,0,1,1},
                                                        {1,0,0,0,1,1,1,1,0,1},
                                                        {1,1,1,1,1,1,1,0,1,0},
                                                        {1,1,1,1,0,1,0,0,1,1}});*/

        for (int[] raw : res)
        {
            Arrays.stream(raw).forEach(System.out::println);
            System.out.println("--------- New Raw ----------");
        }
    }

    private static class Solution
    {
        public int[][] updateMatrix(int[][] mat)
        {
            int [][] res = new int[mat.length][mat[0].length];

            ArrayList<ArrayList<ArrayList<Integer[]>>> myGraph = createGraph(mat);
            Queue<String> unvisitedCells = new ArrayDeque<>();
            HashSet<String> visitedCells = new HashSet<>();

            for (int raw = 0; raw < mat.length; raw++)
            {
                for (int col = 0; col < mat[0].length; col++)
                {
                    int level = 0;

                    unvisitedCells.clear();
                    visitedCells.clear();

                    unvisitedCells.add(raw + " " + col + " " + level);

                    while (!unvisitedCells.isEmpty())
                    {
                        String[] position = unvisitedCells.poll().split(" ");
                        visitedCells.add(position[0] + " " + position[1]);

                        if (mat[Integer.parseInt(position[0])][Integer.parseInt(position[1])] == 0)
                        {
                            res[raw][col] = Integer.parseInt(position[2]);
                            break;
                        }

                        ArrayList<Integer[]> children = myGraph.get(Integer.parseInt(position[0])).get(Integer.parseInt(position[1]));

                        if (!children.isEmpty()) level = Integer.parseInt(position[2]) + 1;

                        for (Integer[] pos : children)
                        {
                            if (!visitedCells.contains(pos[0] + " " + pos[1])) unvisitedCells.add(pos[0] + " " + pos[1] + " " + level);
                        }
                    }
                }
            }

            return res;
        }

        private ArrayList<ArrayList<ArrayList<Integer[]>>> createGraph(int [][] mat)
        {
            ArrayList<ArrayList<ArrayList<Integer[]>>> graph = new ArrayList<>();

            for (int raw = 0; raw < mat.length; raw++)
            {
                graph.add(new ArrayList<>());

                for (int col = 0; col < mat[0].length; col++)
                {
                    graph.get(raw).add(new ArrayList<>());

                    // left
                    if (col - 1 >= 0) graph.get(raw).get(col).add(new Integer[]{raw, col - 1});

                    // right
                    if (col + 1 < mat[0].length) {

                        graph.get(raw).get(col).add(new Integer[]{raw, col + 1});
                    }

                    // up
                    if (raw - 1 >= 0) graph.get(raw).get(col).add(new Integer[]{raw - 1, col});

                    // down
                    if (raw + 1 < mat.length) graph.get(raw).get(col).add(new Integer[]{raw + 1, col});
                }
            }

            return graph;
        }

        /// --------------------- Try with Arrays instead of Arraylists ------------------------------------

        public int[][] updateMatrix2(int[][] mat)
        {
            int [][] res = new int[mat.length][mat[0].length];

            ArrayList<Integer[]>[][] myGraph = createGraph2(mat);
            Queue<String> unvisitedCells = new ArrayDeque<>();
            HashSet<String> visitedCells = new HashSet<>();

            for (int raw = 0; raw < mat.length; raw++)
            {
                for (int col = 0; col < mat[0].length; col++)
                {
                    int level = 0;

                    unvisitedCells.clear();
                    visitedCells.clear();

                    unvisitedCells.add(raw + " " + col + " " + level);

                    while (!unvisitedCells.isEmpty())
                    {
                        String[] position = unvisitedCells.poll().split(" ");
                        visitedCells.add(position[0] + " " + position[1]);

                        if (mat[Integer.parseInt(position[0])][Integer.parseInt(position[1])] == 0)
                        {
                            res[raw][col] = Integer.parseInt(position[2]);
                            break;
                        }

                        ArrayList<Integer[]> children = myGraph[Integer.parseInt(position[0])][Integer.parseInt(position[1])];

                        if (!children.isEmpty()) level = Integer.parseInt(position[2]) + 1;

                        for (Integer[] pos : children)
                        {
                            if (!visitedCells.contains(pos[0] + " " + pos[1])) unvisitedCells.add(pos[0] + " " + pos[1] + " " + level);
                        }
                    }
                }
            }

            return res;
        }

        private ArrayList<Integer[]>[][] createGraph2(int [][] mat)
        {
            ArrayList<Integer[]>[][] graph = new ArrayList[mat.length][mat[0].length];

            for (int raw = 0; raw < mat.length; raw++)
            {
                for (int col = 0; col < mat[0].length; col++)
                {
                    if (mat[raw][col] == 1)
                    {
                        graph[raw][col] = new ArrayList<>();

                        // left
                        if (col - 1 >= 0) graph[raw][col].add(new Integer[]{raw, col - 1});

                        // right
                        if (col + 1 < mat[0].length) {

                            graph[raw][col].add(new Integer[]{raw, col + 1});
                        }

                        // up
                        if (raw - 1 >= 0) graph[raw][col].add(new Integer[]{raw - 1, col});

                        // down
                        if (raw + 1 < mat.length) graph[raw][col].add(new Integer[]{raw + 1, col});
                    }
                }
            }

            return graph;
        }

        /// ---------------- Try with DP Way ---------------------------------

        public int[][] updateMatrix3(int[][] mat)
        {
            int[][] res = new int[mat.length][mat[0].length];
            int MAX_DIST = mat.length * mat[0].length;

            // First, we check for above & left
            for (int raw = 0; raw < mat.length; raw++)
            {
                for (int col = 0; col < mat[0].length; col++)
                {
                    if (mat[raw][col] != 0)
                    {
                        int above = MAX_DIST;
                        int left = MAX_DIST;

                        // check above
                        if (raw - 1 >= 0) above = mat[raw - 1][col];

                        // check left
                        if (col - 1 >= 0) left = mat[raw][col - 1];

                        res[raw][col] = Math.min(above, left) + 1;
                    }

                }
            }

            // Second, we check for down & right
            for (int raw = 0; raw < mat.length; raw++)
            {
                for (int col = 0; col < mat[0].length; col++)
                {
                    if (mat[raw][col] != 0)
                    {
                        int down = MAX_DIST;
                        int right = MAX_DIST;

                        // check down
                        if (raw + 1 < mat.length) down = mat[raw + 1][col];

                        // check right
                        if (col + 1 < mat[0].length) right = mat[raw][col + 1];

                        res[raw][col] = Math.min(Math.min(down, right) + 1, res[raw][col]);
                    }

                }
            }

            return res;
        }
    }
}
