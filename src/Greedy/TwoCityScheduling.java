package Greedy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class TwoCityScheduling
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        System.out.println(solution.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
    }

    private static class Solution
    {
        public int twoCitySchedCost(int[][] costs)
        {
            int n = costs.length / 2;
            int minCost = 0;
            PriorityQueue<Integer[]> myQueue = new PriorityQueue<>(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    if (o1[1] > o2[1]) return 1;
                    else if (o1[1] < o2[1]) return -1;
                    return 0;
                }
            });

            for (int i = 0; i < costs.length; i++)
                myQueue.add(new Integer[]{i, costs[i][1] - costs[i][0]});

            int time = 0;
            while (!myQueue.isEmpty())
            {
                Integer[] diff = myQueue.poll();
                if (time < n) minCost += costs[diff[0]][1];
                else minCost += costs[diff[0]][0];

                time++;
            }

            return minCost;
        }
    }
}
