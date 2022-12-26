package Graphs;

import java.util.*;

public class CourseScheduleII
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        /*int[] res = solution.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        Arrays.stream(res).forEach(System.out::println);*/

        /// this example should return empty array, but the result is wrong ....
        int[] res = solution.findOrder(2, new int[][]{{1,0},{0,1}});
        Arrays.stream(res).forEach(System.out::println);

    }

    private static class Solution
    {
        int[] parents;
        public int[] findOrder(int numCourses, int[][] prerequisites)
        {
            ArrayList<Integer> courses = new ArrayList<>();

            if (prerequisites.length == 0)
            {
                for (int i = 0; i < numCourses; i++) courses.add(i);

                return courses.stream().mapToInt(Integer::intValue).toArray();
            }

            ArrayList<Integer>[] graph = createGraph(numCourses, prerequisites);
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> unvisited = new ArrayDeque<>();

            unvisited.add(find(0));

            while (!unvisited.isEmpty())
            {
                int currentCourse = unvisited.poll();

                if (!visited.contains(currentCourse))
                {
                    visited.add(currentCourse);
                    courses.add(currentCourse);

                    ArrayList<Integer> children = graph[currentCourse];

                    for (int child : children)
                    {
                        if (!visited.contains(child)) unvisited.add(child);
                    }
                }
            }

            return courses.stream().mapToInt(Integer::intValue).toArray();
        }

        private ArrayList<Integer>[] createGraph(int numCourses, int[][] prerequisites)
        {
            ArrayList<Integer>[] graph = new ArrayList[numCourses];
            parents = new int[numCourses];

            for (int i = 0; i < numCourses; i++)
            {
                graph[i] = new ArrayList<>();
                parents[i] = i;
            }

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
