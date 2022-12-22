package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
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
            int minTime = 0;
            HashSet<Integer> visited = new HashSet<>();
            visited.add(k);

            int[] dist = new int[n];

            int[][] graph = createGraph(times, n);

            for (int i = 0; i < n; i++)
            {
                if (i == k) dist[i] = 0;
                else dist[i] = 101;
            }

            int currentNode = k - 1;
            while (visited.size() < n)
            {
                int [] nextNodes = graph[currentNode];

                int minDist = 101;
                int nextNode = 0;
                for (int next = 0; next < n; next++)
                {
                    if (next != currentNode && !visited.contains(next) && graph[currentNode][next] != -1)
                    {
                        dist[next] = Math.min(dist[next], minTime + graph[currentNode][next]);

                        if (minDist > dist[next])
                        {
                            minDist = dist[next];
                            nextNode = next;
                        }
                    }
                }

                visited.add(currentNode);
                if (visited.size() == n) return minTime;

                currentNode = nextNode;
                minTime += minDist;
            }

            return minTime;
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

    }
}
