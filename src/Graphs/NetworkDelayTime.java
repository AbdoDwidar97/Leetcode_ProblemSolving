package Graphs;
import java.util.HashSet;

public class NetworkDelayTime
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }

    private static class Solution
    {
        public int networkDelayTime(int[][] times, int n, int k)
        {
            int[][] graph = createGraph(times, n);
            int[] dist = new int[n];
            for (int i = 0; i < n; i++)
            {
                if (i == k - 1) dist[i] = 0;
                else dist[i] = 101;
            }

            return dfsDijkstra(graph, dist, k - 1, 0, new HashSet<>());
        }

        private int[][] createGraph(int[][] times, int n)
        {
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    graph[i][j] = -1;
                }
            }

            for (int[] edge : times)
            {
                int source = edge[0] - 1;
                int target = edge[1] - 1;

                graph[source][target] = edge[2];
            }

            return graph;
        }

        private int dfsDijkstra(int[][] graph, int[] dist, int currentNode, int distance, HashSet<Integer> visited)
        {
            /// Working on ....
            visited.add(currentNode);

            int longestPath = 0;

            for (int i = 0; i < graph.length; i++)
            {
                if (!visited.contains(i) && graph[currentNode][i] >= 0)
                {
                    dist[i] = Math.min(dist[i], distance + graph[currentNode][i]);
                }
            }

            for (int i = 0; i < graph.length; i++)
            {

            }

            return 0;
        }
    }
}
