package Graphs;

import java.util.*;

public class MinimumFuelCostToReportToTheCapital
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        //System.out.println(solution.minimumFuelCost(new int[][]{{0,1},{0,2},{0,3}}, 5));
        System.out.println(solution.minimumFuelCost(new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}}, 2));
        //System.out.println(solution.minimumFuelCost(new int[][]{}, 1));
        //System.out.println(solution.minimumFuelCost(new int[][]{{1,0},{0,2},{3,1},{1,4},{5,0}}, 1));
    }

    private static class Solution
    {
        private long minLitters = 0;
        public long minimumFuelCost(int[][] roads, int seats)
        {
            if (roads.length == 0) return 0;
            ArrayList<Integer>[] graph = buildGraph(roads);
            dfsTravel(graph, 0, seats, 0, new HashSet<>());
            return minLitters;
        }

        private ArrayList<Integer>[] buildGraph(int[][] roads)
        {
            ArrayList<Integer>[] graph = new ArrayList[roads.length + 1];
            for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();

            for (int[] road : roads)
            {
                int a = road[0];
                int b = road[1];

                graph[a].add(b);
                graph[b].add(a);
            }

            return graph;
        }

        private int dfsTravel(ArrayList<Integer>[] graph, int currentCity, int seats, int distance, HashSet<Integer> visited)
        {
            visited.add(currentCity);

            ArrayList<Integer> children = graph[currentCity];

            int people = 1;
            for (int cty : children)
            {
                if (!visited.contains(cty))
                    people += dfsTravel(graph, cty, seats, distance + 1, visited);
            }

            if (currentCity == 0) return 0;

            if (people < seats)
            {
                minLitters++;
                return people;
            }

            int carsNumber = people / seats;
            minLitters += (long) carsNumber * distance;

            int additionalPeople = people % seats;

            if (additionalPeople == 0) return 0;
            else
            {
                minLitters++;
                return additionalPeople;
            }
        }
    }
}
