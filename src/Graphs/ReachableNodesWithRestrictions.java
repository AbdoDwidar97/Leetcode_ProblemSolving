package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class ReachableNodesWithRestrictions
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.reachableNodes(7, new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}}, new int[]{4, 5}));
    }

    private static class Solution
    {
        public int reachableNodes(int n, int[][] edges, int[] restricted)
        {
            HashSet<Integer> visited = new HashSet<>();
            for (int rest : restricted)
            {
                if (rest == 0) return 0;
                visited.add(rest);
            }

            ArrayList<Integer>[] graph = buildGraph(n, edges);
            Queue<Integer> unvisited = new ArrayDeque<>();

            unvisited.add(0);

            while (!unvisited.isEmpty())
            {
                int node = unvisited.poll();
                visited.add(node);

                ArrayList<Integer> children = graph[node];

                for (int child : children)
                {
                    if (!visited.contains(child)) unvisited.add(child);
                }
            }

            return visited.size() - restricted.length;
        }

        private ArrayList<Integer>[] buildGraph(int n, int[][] edges)
        {
            ArrayList<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

            for (int[] edge : edges)
            {
                int a = edge[0];
                int b = edge[1];

                graph[a].add(b);
                graph[b].add(a);
            }

            return graph;
        }
    }
}
