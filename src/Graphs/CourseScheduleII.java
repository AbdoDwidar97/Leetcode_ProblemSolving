package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class CourseScheduleII
{
    public static void main(String[] args)
    {
        // Working on ...
    }

    private static class Solution
    {
        int[] parents;
        public int[] findOrder(int numCourses, int[][] prerequisites)
        {
            ArrayList<Integer> coursesOrder = new ArrayList<>();

            parents = new int[numCourses];
            HashSet<Integer> availCourses = new HashSet<>();
            Queue<Integer> unvisited = new ArrayDeque<>();
            ArrayList<Integer>[] graph = new ArrayList[numCourses];

            for (int i = 0; i < numCourses; i++)
            {
                parents[i] = i;
                availCourses.add(i);
                graph[i] = new ArrayList<>();
            }

            graph = createGraph(prerequisites, graph);

            unvisited.add(find(0));

            while (!unvisited.isEmpty())
            {
                int root = unvisited.poll();
                availCourses.remove(root);
                coursesOrder.add(root);

                ArrayList<Integer> children = graph[root];

                for (int child : children)
                {
                    if (availCourses.contains(child)) unvisited.add(child);
                }
            }

            return new int[]{};
        }

        private ArrayList<Integer>[] createGraph(int[][] prerequisites, ArrayList<Integer>[] graph)
        {
            for (int[] edge : prerequisites)
            {
                int a = edge[0];
                int b = edge[1];

                graph[b].add(a);

                if (find(a) != find(b)) union(a, b);
            }

            return graph;
        }

        private int find(int node)
        {
            if (parents[node] == node) return parents[node];
            else return find(parents[node]);
        }

        private void union(int node, int parent)
        {
            int nodeRoot = find(node);
            int parentRoot = find(parent);

            parents[nodeRoot] = parentRoot;
        }
    }
}
