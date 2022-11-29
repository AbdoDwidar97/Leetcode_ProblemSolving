package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;

public class NumberOfProvinces
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}));
        System.out.println(solution.findCircleNum(new int[][]{{1,0,0}, {0,1,0}, {0,0,1}}));
    }

    private static class Solution
    {
        public int findCircleNum(int[][] isConnected)
        {
            int numOfProvinces = 0;
            ArrayList<Integer> unvisitedNodes = new ArrayList<>();
            HashSet<Integer> visitedNodes = new HashSet<>();
            Queue<Integer> onGoingNodes = new ArrayDeque<>();

            for (int i = 0; i < isConnected.length; i++) unvisitedNodes.add(i);

            while (!unvisitedNodes.isEmpty())
            {
                onGoingNodes.add(unvisitedNodes.get(0));
                numOfProvinces++;

                while (!onGoingNodes.isEmpty())
                {
                    Integer currentNode = onGoingNodes.poll();
                    visitedNodes.add(currentNode);
                    unvisitedNodes.remove(currentNode);

                    int [] children = isConnected[currentNode];
                    for (int i = 0; i < children.length; i++)
                    {
                        if (!visitedNodes.contains(i) && children[i] == 1) onGoingNodes.add(i);
                    }
                }

            }

            return numOfProvinces;
        }
    }
}
