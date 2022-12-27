package Graphs;

import java.util.*;

public class CourseScheduleII
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        int[] res = solution.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
        Arrays.stream(res).forEach(System.out::println);

        /// this example should return empty array, but the result is wrong ....
        /*int[] res = solution.findOrder(2, new int[][]{{1,0},{0,1}});
        Arrays.stream(res).forEach(System.out::println);*/

    }

    private static class Solution
    {
        private HashSet<Integer> availCourses = new HashSet<>();
        public int[] findOrder(int numCourses, int[][] prerequisites)
        {
            ArrayList<Integer>[] graph = createGraphAndSetupAvailCourses(numCourses, prerequisites);

            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < numCourses; i++)
            {
                if (availCourses.contains(i))
                {
                    ArrayList<Integer> res = dfsFindOrder(graph, i, new HashSet<>());
                    if (res.isEmpty()) return new int[]{};
                    result.addAll(res);
                }
            }

            int[] allResults = new int[result.size()];
            Arrays.setAll(allResults, result::get);
            return allResults;
        }

        private ArrayList<Integer>[] createGraphAndSetupAvailCourses(int numCourses, int[][] prerequisites)
        {
            ArrayList<Integer>[] graph = new ArrayList[numCourses];

            for (int i = 0; i < numCourses; i++)
            {
                graph[i] = new ArrayList<>();
                availCourses.add(i);
            }

            for (int[] edge : prerequisites)
            {
                int a = edge[0];
                int b = edge[1];

                graph[a].add(b);
            }

            return graph;
        }

        private ArrayList<Integer> dfsFindOrder(ArrayList<Integer>[] graph, int currentNode, HashSet<Integer> visited)
        {
            HashSet<Integer> myVisited = new HashSet<>(visited);
            myVisited.add(currentNode);

            ArrayList<Integer> children = graph[currentNode];

            ArrayList<Integer> result = new ArrayList<>();
            for (int course : children)
            {
                if (visited.contains(course)) return new ArrayList<>();
                if (availCourses.contains(course))
                {
                    ArrayList<Integer> res = dfsFindOrder(graph, course, myVisited);
                    if (res.isEmpty()) return res;

                    result.addAll(res);
                }
            }

            result.add(currentNode);
            availCourses.remove(currentNode);

            return result;
        }
    }
}
