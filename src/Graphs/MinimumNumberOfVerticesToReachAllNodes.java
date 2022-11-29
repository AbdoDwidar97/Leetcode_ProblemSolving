package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(0, 1));
        list.add(Arrays.asList(0, 2));
        list.add(Arrays.asList(2, 5));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(4, 2));

        solution.findSmallestSetOfVertices2(6, list).forEach(System.out::println);
    }

    private static class Solution
    {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges)
        {
            HashSet<Integer> sources = new HashSet<>();
            HashSet<Integer> destinations = new HashSet<>();

            for (List<Integer> edge : edges)
            {
                sources.add(edge.get(0));
                destinations.add(edge.get(1));
            }

            sources.removeAll(destinations);
            return sources.stream().toList();
        }

        // ------------------------- Try Smart way -----------------------------------------

        public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges)
        {
            HashSet<Integer> sources = new HashSet<>();

            for (int i = 0; i < n; i++) sources.add(i);

            for (List<Integer> edge : edges)
            {
                sources.remove(edge.get(1));
            }

            return sources.stream().toList();
        }

    }
}
