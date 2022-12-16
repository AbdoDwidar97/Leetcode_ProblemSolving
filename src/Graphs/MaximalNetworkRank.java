package Graphs;

public class MaximalNetworkRank
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}}));
        System.out.println(solution.maximalNetworkRank(3, new int[][]{{0,2},{0,1}}));
        System.out.println(solution.maximalNetworkRank(5, new int[][]{{2,3},{0,3},{0,4},{4,1}}));
    }

    private static class Solution
    {
        boolean[][] graph;
        public int maximalNetworkRank(int n, int[][] roads)
        {
            if (roads.length == 1) return 1;
            int[] children = getNodesChildrenNumberAndBuildGraph(n, roads);

            int maxRank = 0;
            for (int i = 1; i < n; i++)
            {
                int rank;
                for (int j = 1; j < n; j++)
                {
                    if (i != j)
                    {
                        if (graph[i][j]) rank = children[i] + children[j] - 1;
                        else rank = children[i] + children[j];

                        maxRank = Math.max(maxRank, rank);
                    }
                }
            }

            return maxRank;
        }

        private int[] getNodesChildrenNumberAndBuildGraph(int n, int[][] roads)
        {
            int[] children = new int[n];
            graph = new boolean[n][n];

            for (int[] road : roads)
            {
                int a = road[0];
                int b = road[1];

                children[a]++;
                children[b]++;

                graph[a][b] = true;
                graph[b][a] = true;
            }

            return children;
        }
    }
}
