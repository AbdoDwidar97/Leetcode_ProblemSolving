package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EvaluateDivision
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        /*List<List<String>> equations = List.of(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        List<List<String>> queries = List.of(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        double[] result = solution.calcEquation(equations, new double[]{2.0, 3.0}, queries);
        Arrays.stream(result).forEach(System.out::println);*/

        /// ------------------------------------------------------------------

        List<List<String>> equations = List.of(Arrays.asList("a", "e"), Arrays.asList("b", "e"));
        List<List<String>> queries = List.of(Arrays.asList("a", "b"), Arrays.asList("e", "e"), Arrays.asList("x", "x"));
        double[] result = solution.calcEquation(equations, new double[]{4.0, 3.0}, queries);
        Arrays.stream(result).forEach(System.out::println);

        /// ------------------------------------------------------------------

        /*List<List<String>> equations = List.of(Arrays.asList("a","b"), Arrays.asList("c","b"), Arrays.asList("d","b"), Arrays.asList("w","x"), Arrays.asList("y","x"), Arrays.asList("z","x"), Arrays.asList("w","d"));
        List<List<String>> queries = List.of(Arrays.asList("a", "c"), Arrays.asList("b", "c"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"), Arrays.asList("a", "z"));
        double[] result = solution.calcEquation(equations, new double[]{2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0}, queries);
        Arrays.stream(result).forEach(System.out::println);*/
    }

    private static class Solution
    {
        private HashMap<String, Integer> nodesAddress = new HashMap<>();
        private int[] parents;
        private double [][] graph;
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
        {
            double[] result = new double[queries.size()];
            buildNodeAddresses(equations);
            buildGraph(equations, values);

            for (int i = 0; i < result.length; i++)
            {
                List<String> q = queries.get(i);
                String node1 = q.get(0);
                String node2 = q.get(1);

                if (!nodesAddress.containsKey(node1) || !nodesAddress.containsKey(node2)) result[i] = -1;
                else
                {
                    if (find(nodesAddress.get(node1)) != find(nodesAddress.get(node2))) result[i] = -1;
                    else
                    {
                        int target = find(nodesAddress.get(node1));
                        double value1 = findValue(nodesAddress.get(node1), target, 1.0);
                        double value2 = findValue(nodesAddress.get(node2), target, 1.0);

                        result[i] = value2 / value1;
                    }
                }
            }

            return result;
        }

        private void buildNodeAddresses(List<List<String>> equations)
        {
            int nodesNumber = 0;
            for (List<String> edge : equations)
            {
                if (!nodesAddress.containsKey(edge.get(0))) nodesAddress.put(edge.get(0), nodesNumber++);
                if (!nodesAddress.containsKey(edge.get(1))) nodesAddress.put(edge.get(1), nodesNumber++);
            }
        }

        private void buildGraph(List<List<String>> equations, double[] values)
        {
            graph = new double[nodesAddress.size()][nodesAddress.size()];
            parents = new int[nodesAddress.size()];

            for (int i = 0; i < parents.length; i++) parents[i] = i;

            for (int i = 0; i < values.length; i++)
            {
                List<String> edge = equations.get(i);
                int parentIdx = nodesAddress.get(edge.get(0));
                int nodeIdx = nodesAddress.get(edge.get(1));

                graph[parentIdx][nodeIdx] = values[i];
                graph[nodeIdx][parentIdx] = 1.0 / values[i];

                if (find(nodeIdx) != find(parentIdx)) union(nodeIdx, parentIdx);
            }
        }

        private int find(int nodeIdx)
        {
            if (parents[nodeIdx] != nodeIdx)
                return find(parents[nodeIdx]);

            return parents[nodeIdx];
        }

        private void union2(int nodeIdx, int parentIdx)
        {
            if (parents[nodeIdx] != nodeIdx) {
                // parents[parentIdx] = nodeIdx;
                updateParents(parents[nodeIdx], nodeIdx);
                parents[parentIdx] = nodeIdx;
            }
            else parents[nodeIdx] = parentIdx;
        }

        private void union(int nodeIdx, int parentIdx)
        {
            int nodeRootIdx = find(nodeIdx);
            int parentRootIdx = find(parentIdx);

            parents[nodeRootIdx] = parentRootIdx;
        }

        private void updateParents(int parentIdx, int currentIdx)
        {
            if (parents[parentIdx] == parentIdx) return;
            updateParents(parents[parentIdx], parentIdx);
            parents[parentIdx] = currentIdx;
        }

        private double findValue(int source, int target, double totalVal)
        {
            double total = 0.0;

            if (source == target) return totalVal;
            else if (parents[source] != source)
            {
                total = totalVal * graph[parents[source]][source];
                return findValue(parents[source], target, total);
            }

            return 0.0;
        }
    }
}
