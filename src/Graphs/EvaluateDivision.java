package Graphs;

import java.util.Arrays;
import java.util.List;

public class EvaluateDivision
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        List<List<String>> equations = List.of(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        List<List<String>> queries = List.of(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        double[] result = solution.calcEquation(equations, new double[]{2.0, 3.0}, queries);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static class Solution
    {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
        {
            /// Solution here ...
            return null;
        }
    }
}
