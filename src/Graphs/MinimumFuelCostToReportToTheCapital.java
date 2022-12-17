package Graphs;

import java.util.*;

public class MinimumFuelCostToReportToTheCapital
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // System.out.println(solution.minimumFuelCost(new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}}, 2));
        System.out.println(solution.minimumFuelCost(new int[][]{}, 1));
    }

    private static class Solution
    {
        HashMap<Integer, Integer> citiesRank = new HashMap<>();
        Queue<Integer> startCities = new ArrayDeque<>();
        boolean[] goneRepresentatives;

        public long minimumFuelCost(int[][] roads, int seats)
        {
            if (roads.length == 0) return 0;
            long minLiters = 0;

            goneRepresentatives = new boolean[roads.length + 1];

            ArrayList<Integer>[] graph = buildGraph(roads);

            for (int i = 0; i <= roads.length; i++)
            {
                if (citiesRank.get(i) == 1) startCities.add(i);
            }

            while (!startCities.isEmpty())
            {
                int city = startCities.poll();
                minLiters += dfsTravel(graph, city, seats, 0, new HashSet<>());
            }

            return minLiters;
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

                if (citiesRank.containsKey(a)) citiesRank.put(a, citiesRank.get(a) + 1);
                else citiesRank.put(a, 1);

                if (citiesRank.containsKey(b)) citiesRank.put(b, citiesRank.get(b) + 1);
                else citiesRank.put(b, 1);
            }

            return graph;
        }

        private long dfsTravel(ArrayList<Integer>[] graph, int city, int availSeat, int liters, HashSet<Integer> visited)
        {
            visited.add(city);
            if (city == 0) return liters;

            int seat = availSeat;
            if (availSeat == 0)
            {
                startCities.add(city);
                seat = -1;
            }
            else if (availSeat > 0 && !goneRepresentatives[city])
            {
                seat--;
                goneRepresentatives[city] = true;
            }

            ArrayList<Integer> children = graph[city];

            long myLiters = 0;
            for (Integer cty : children)
            {
                if (!visited.contains(cty)) myLiters += dfsTravel(graph, cty, seat, liters + 1, visited);
            }

            return myLiters;
        }
    }
}
