package Greedy;

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
            int aCost = dfsGetMinCost(costs, 0, 0, 0, 0);
            int bCost = dfsGetMinCost(costs, 0, 0, 0, 0);

            return Math.min(aCost, bCost);
        }

        private int dfsGetMinCost(int[][] costs, int currentIdx, int totalCost, int aLngth, int bLngth)
        {
            if (currentIdx == costs.length)
            {
                if (aLngth == bLngth) return totalCost;
                else return Integer.MAX_VALUE;
            }

            int costA = dfsGetMinCost(costs, currentIdx + 1, totalCost + costs[currentIdx][0], aLngth + 1, bLngth);
            int costB = dfsGetMinCost(costs, currentIdx + 1, totalCost + costs[currentIdx][1], aLngth, bLngth + 1);

            return Math.min(costA, costB);
        }
    }
}
