package Graphs;

import java.util.*;

public class CriticalConnectionsInNetwork
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        List<List<Integer>> connections = new ArrayList<>();
        /*connections.add(new ArrayList<>(List.of(0, 1)));
        connections.add(new ArrayList<>(List.of(1, 2)));
        connections.add(new ArrayList<>(List.of(2, 0)));
        connections.add(new ArrayList<>(List.of(1, 3)));*/

        /*connections.add(new ArrayList<>(List.of(0, 2)));
        connections.add(new ArrayList<>(List.of(2, 1)));
        connections.add(new ArrayList<>(List.of(0, 1)));
        connections.add(new ArrayList<>(List.of(3, 1)));
        connections.add(new ArrayList<>(List.of(3, 5)));
        connections.add(new ArrayList<>(List.of(4, 5)));
        connections.add(new ArrayList<>(List.of(4, 3)));*/

        connections.add(new ArrayList<>(List.of(1, 0)));
        connections.add(new ArrayList<>(List.of(2, 1)));
        connections.add(new ArrayList<>(List.of(3, 2)));
        connections.add(new ArrayList<>(List.of(4, 2)));
        connections.add(new ArrayList<>(List.of(2, 0)));
        connections.add(new ArrayList<>(List.of(3, 0)));
        connections.add(new ArrayList<>(List.of(4, 0)));

        List<List<Integer>> res = solution.criticalConnections(5, connections);

        for (List<Integer> itr : res)
        {
            itr.forEach(System.out::println);
            System.out.println("------");
        }
    }

    private static class Solution
    {
        /// -------------------- Try with (Tarjan & DFS) way -------------------------------------------

        private final HashSet<Integer> visitedNodes = new HashSet<>();
        private final List<List<Integer>> criticalEdges = new ArrayList<>();
        private int time = 0;
        int [] lowLinks;

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
        {
            lowLinks = new int[n];
            ArrayList<Integer>[] myGraph = createGraph(n, connections);
            dfsSearchGraph(myGraph, connections.get(0).get(0), new Stack<>());
            return criticalEdges;
        }

        private void dfsSearchGraph(ArrayList<Integer>[] graph, int currentNode, Stack<Integer> visitedCycle)
        {
            if (visitedCycle.contains(currentNode))
            {
                /*int minParentLowLink = lowLinks[currentNode];

                for (Integer child : graph[currentNode])
                    if (lowLinks[child] < minParentLowLink)
                        minParentLowLink = lowLinks[child];

                lowLinks[currentNode] = minParentLowLink;*/
                lowLinks[currentNode] = Math.min(lowLinks[currentNode], lowLinks[visitedCycle.peek()]);
                return;
            }

            if (visitedNodes.contains(currentNode)) return;

            visitedNodes.add(currentNode);
            Stack<Integer> myVisitedCycle = new Stack<>();
            myVisitedCycle.addAll(visitedCycle);
            myVisitedCycle.add(currentNode);
            lowLinks[currentNode] = time++;

            for (Integer child : graph[currentNode])
            {
                if (visitedCycle.isEmpty() || !child.equals(visitedCycle.peek()))
                {
                    dfsSearchGraph(graph, child, myVisitedCycle);
                    if (lowLinks[currentNode] >= lowLinks[child]) lowLinks[currentNode] = lowLinks[child];
                    else criticalEdges.add(new ArrayList<>(List.of(currentNode, child)));
                }
            }
        }

        private ArrayList<Integer>[] createGraph(int n, List<List<Integer>> connections)
        {
            ArrayList<Integer>[] myGraph = new ArrayList[n];

            // initialize
            for (int i = 0; i < n; i++) myGraph[i] = new ArrayList<>();

            for (List<Integer> con : connections)
            {
                int a = con.get(0);
                int b = con.get(1);

                myGraph[a].add(b);
                myGraph[b].add(a);
            }

            return myGraph;
        }


    }
}
