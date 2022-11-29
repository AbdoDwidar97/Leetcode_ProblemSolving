package Graphs;

import java.util.*;

public class AllPathsFromSourceToTarget
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // List<List<Integer>> res = solution.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
        List<List<Integer>> res = solution.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});

        for (List<Integer> path : res)
        {
            path.forEach(System.out::println);
            System.out.println("-------------");
        }
    }

    private static class Solution
    {
        private List<List<Integer>> allPaths = new ArrayList<>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph)
        {
            allPaths.clear();
            dfsTraverse(graph, new ArrayList<>(), 0);
            return allPaths;
        }

        private void dfsTraverse(int[][] graph, List<Integer> path, int node)
        {
            List<Integer> myPath = new ArrayList<>(path);
            myPath.add(node);

            if (node == graph.length - 1)
            {
                allPaths.add(myPath);
                return;
            }

            int [] children = graph[node];

            if (children.length == 0) return;

            for (int child : children)
            {
                dfsTraverse(graph, myPath, child);
            }

        }

    }
}
