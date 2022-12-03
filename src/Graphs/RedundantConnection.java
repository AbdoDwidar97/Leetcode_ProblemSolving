package Graphs;

import java.util.Arrays;

public class RedundantConnection
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // int [] edge = solution.findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}});
        int [] edge2 = solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});

        Arrays.stream(edge2).forEach(System.out::println);
    }

    private static class Solution
    {
        /// Solving this problem with union find algorithm.
        private int[] parents;
        /*public int[] findRedundantConnection(int[][] edges)
        {
            for (int i = edges.length - 1; i >= 0; i--)
            {
                int components = countComponents(edges, i);
                if (components == 1) return edges[i];
            }

            return edges[0];
        }

        private int countComponents(int [][] edges, int ignoredEdgeIndex)
        {
            int numOfComponents = edges.length;
            parents = new int[edges.length];
            for (int i = 0; i < parents.length; i++) parents[i] = i;

            for (int i = 0; i < edges.length; i++)
            {
                if (i != ignoredEdgeIndex)
                {
                    if (find(edges[i][0] - 1) != find(edges[i][1] - 1))
                    {
                        union(edges[i][1] - 1, edges[i][0] - 1);
                        numOfComponents--;
                    }
                }
            }

            return numOfComponents;
        }

        private int find(int node)
        {
            return parents[node];
        }

        private void union(int node, int parent)
        {
            int newParentVal = parents[parent];
            int currentNodeVal = parents[node];

            for (int i = 0; i < parents.length; i++)
            {
                if (parents[i] == currentNodeVal) parents[i] = newParentVal;
            }
        }*/

        /// Solving this problem with union find algorithm. (More efficient way)
        public int[] findRedundantConnection(int[][] edges)
        {
            parents = new int[edges.length];
            for (int i = 0; i < parents.length; i++) parents[i] = i;

            for (int[] edge : edges)
            {
                if (find(edge[0] - 1) == find(edge[1] - 1)) return edge;
                union(edge[1] - 1, edge[0] - 1);
            }

            return edges[0];
        }

        private int find(int node)
        {
            return parents[node];
        }

        private void union(int node, int parent)
        {
            int newParentVal = parents[parent];
            int currentNodeVal = parents[node];

            for (int i = 0; i < parents.length; i++)
            {
                if (parents[i] == currentNodeVal) parents[i] = newParentVal;
            }
        }

    }
}
