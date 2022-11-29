package Graphs;

import java.util.*;

public class FindTheTownJudge
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.findJudge(2, new int[][]{{1, 2}}));
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }

    private static class Solution
    {
        public int findJudge(int n, int[][] trust)
        {
            if (trust.length == 1) return trust[0][1];

            ArrayList<ArrayList<Integer>> myGraph = createGraph(n, trust);

            Optional<ArrayList<Integer>> target = myGraph.stream().filter(ArrayList::isEmpty).findFirst();

            if (target.isPresent())
            {
                int targetValue = myGraph.indexOf(target.get()) + 1;

                for (int i = 0; i < myGraph.size(); i++)
                {
                    if (i != targetValue - 1 && !myGraph.get(i).contains(targetValue - 1)) return -1;
                }

                return targetValue;
            }
            else return -1;
        }

        private ArrayList<ArrayList<Integer>> createGraph(int n, int [][] trust)
        {
            ArrayList<ArrayList<Integer>> myGraph = new ArrayList<>();
            for (int i = 0; i < n; i++) myGraph.add(new ArrayList<>());

            for (int[] edge : trust)
            {
                myGraph.get(edge[0] - 1).add(edge[1] - 1);
            }

            return myGraph;
        }
    }
}
