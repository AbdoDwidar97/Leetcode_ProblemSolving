package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }

    private static class Solution
    {
        public int minReorder(int n, int[][] connections)
        {
            int minReorder = 0;
            ArrayList<Integer[]>[] graph = createGraph(n, connections);
            boolean[] visited = new boolean[n];
            Queue<Integer> unvisited = new ArrayDeque<>();

            unvisited.add(0);

            while (!unvisited.isEmpty())
            {
                int currentCity = unvisited.poll();
                visited[currentCity] = true;

                ArrayList<Integer[]> children = graph[currentCity];

                for (Integer[] child : children)
                {
                    if (!visited[child[0]])
                    {
                        unvisited.add(child[0]);
                        minReorder += child[1];
                    }
                }
            }

            return minReorder;
        }

        private ArrayList<Integer[]>[] createGraph(int n, int[][] connections)
        {
            ArrayList<Integer[]>[] graph = new ArrayList[n];

            for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

            for (int[] road : connections)
            {
                int a = road[0];
                int b = road[1];

                graph[b].add(new Integer[]{a, 0});
                graph[a].add(new Integer[]{b, 1});
            }

            return graph;
        }

    }
}