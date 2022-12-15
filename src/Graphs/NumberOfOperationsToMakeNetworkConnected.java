package Graphs;

public class NumberOfOperationsToMakeNetworkConnected
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
    }

    private static class Solution
    {
        int[] parents;
        public int makeConnected(int n, int[][] connections)
        {
            if (connections.length < n - 1) return -1;

            parents = new int[n];
            for (int i = 0; i < n; i++) parents[i] = i;

            int numberOfRedundantCables = 0;

            for (int[] edge : connections)
            {
                int a = edge[0];
                int b = edge[1];

                if (find(a) == find(b)) numberOfRedundantCables++;
                else union(b, a);
            }

            int additionalConnections = connections.length - (n - 1);
            return numberOfRedundantCables - additionalConnections;
        }

        private int find(int node)
        {
            if (parents[node] == node) return parents[node];
            return find(parents[node]);
        }

        private void union(int node, int parent)
        {
            int nodeRoot = find(node);
            int parentRoot = find(parent);

            parents[nodeRoot] = parentRoot;
        }
    }
}
