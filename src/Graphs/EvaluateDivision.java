package Graphs;

import java.util.*;

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
        private double[][] graph;
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
        {
            double[] result = new double[queries.size()];
            buildNodeAddress(equations);
            buildGraph(equations, values);

            for (int i = 0; i < queries.size(); i++)
            {
                if (nodesAddress.containsKey(queries.get(i).get(0)) && nodesAddress.containsKey(queries.get(i).get(1)))
                {
                    int aIdx = nodesAddress.get(queries.get(i).get(0));
                    int bIdx = nodesAddress.get(queries.get(i).get(1));

                    double valueDfs = getValueDfs(aIdx, bIdx, 1.0, new HashSet<>());
                    if (valueDfs > 0.0) result[i] = valueDfs;
                    else result[i] = -1.0;
                }
                else result[i] = -1.0;
            }

            return result;
        }

        private double getValueDfs(int nodeFrom, int nodeTo, double totalValue, HashSet<Integer> visitedNodes)
        {
            visitedNodes.add(nodeFrom);
            if (nodeFrom == nodeTo) return totalValue;

            double totalSum = 0.0;
            for (int i = 0; i < graph[nodeFrom].length; i++)
            {
                double child = graph[nodeFrom][i];
                if (child > 0.0 && !visitedNodes.contains(i))
                {
                    totalSum += getValueDfs(i, nodeTo, totalValue * child, visitedNodes);
                }
            }

            return totalSum;
        }

        private void buildNodeAddress(List<List<String>> equations)
        {
            int numOfNodes = 0;
            for (List<String> edge : equations)
            {
                String a = edge.get(0);
                String b = edge.get(1);

                if (!nodesAddress.containsKey(a)) nodesAddress.put(a, numOfNodes++);
                if (!nodesAddress.containsKey(b)) nodesAddress.put(b, numOfNodes++);
            }
        }

        private void buildGraph(List<List<String>> equations, double[] values)
        {
            graph = new double[nodesAddress.size()][nodesAddress.size()];

            for (int i = 0; i < values.length; i++)
            {
                int aIdx = nodesAddress.get(equations.get(i).get(0));
                int bIdx = nodesAddress.get(equations.get(i).get(1));

                graph[aIdx][bIdx] = values[i];
                graph[bIdx][aIdx] = 1.0 / values[i];
            }
        }
    }
}
