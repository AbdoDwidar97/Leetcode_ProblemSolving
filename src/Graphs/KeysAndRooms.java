package Graphs;

import java.util.*;

public class KeysAndRooms
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(List.of());

        System.out.println(solution.canVisitAllRooms(rooms));
    }

    private static class Solution
    {
        public boolean canVisitAllRooms(List<List<Integer>> rooms)
        {
            HashSet<Integer> visitedNodes = new HashSet<>();
            Queue<Integer> unvisitedNodes = new ArrayDeque<>();

            unvisitedNodes.add(0);

            while (!unvisitedNodes.isEmpty())
            {
                int visitedNode = unvisitedNodes.poll();
                visitedNodes.add(visitedNode);

                List<Integer> children = rooms.get(visitedNode);

                for (Integer child : children)
                {
                    if (!visitedNodes.contains(child)) unvisitedNodes.add(child);
                }
            }

            return visitedNodes.size() == rooms.size();
        }
    }

}
