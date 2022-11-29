package Graphs;

import java.util.*;

public class FindIfPathExistsInGraph
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(solution.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
        System.out.println(solution.validPath(1, new int[][]{}, 0, 0));
    }

    private static class Solution
    {
        HashSet<Integer> set = new HashSet<>();
        public boolean validPath(int n, int[][] edges, int source, int destination)
        {
            /*if (destination >= n) return false;
            set.clear();
            return validPathTraverse(edges, source, destination);*/

            if (source == destination) return true;
            if (edges.length == 0) return false;

            return validPathBFSTraverse(createGraph(edges, n), source, destination);
        }

        /// traverse with DFS
        private boolean validPathTraverse(int[][] edges, int source, int destination)
        {
            if (set.contains(source)) return false;
            set.add(source);

            if (source == destination) return true;

            for (int i = 0; i < edges.length; i++)
            {
                if (source == edges[i][0] && validPathTraverse(edges, edges[i][1], destination)) return true;
                else if (source == edges[i][1] && validPathTraverse(edges, edges[i][0], destination)) return true;
            }

            return false;
        }

        /// traverse with BFS
        private ArrayList<ArrayList<Integer>> createGraph(int[][] edges, int n)
        {
            ArrayList<ArrayList<Integer>> myGraph = new ArrayList<>();

            // initGraph
            for (int i = 0; i < n; i++) myGraph.add(new ArrayList<>());

            for (int i = 0; i < edges.length; i++)
            {
                myGraph.get(edges[i][0]).add(edges[i][1]);
                myGraph.get(edges[i][1]).add(edges[i][0]);
            }

            return myGraph;
        }

        private boolean validPathBFSTraverse(ArrayList<ArrayList<Integer>> myGraph, int source, int destination)
        {
            HashSet<Integer> visitedNodes = new HashSet<>();
            Queue<Integer> unvisitedNodes = new ArrayDeque<>();

            unvisitedNodes.add(source);

            while (!unvisitedNodes.isEmpty())
            {
                int node = unvisitedNodes.poll();
                visitedNodes.add(node);

                for (Integer val : myGraph.get(node))
                {
                    if (!visitedNodes.contains(val))
                    {
                        if (val == destination) return true;

                        unvisitedNodes.add(val);
                    }
                }
            }

            return false;
        }
    }
}
