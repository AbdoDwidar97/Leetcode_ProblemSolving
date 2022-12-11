package Graphs;

import java.util.HashSet;

public class MostStonesRemovedWithSameRowOrColumn
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    }

    private static class Solution
    {
        public int removeStones(int[][] stones)
        {
            int numOfStones = 0;
            HashSet<Integer> xSet = new HashSet<>();
            HashSet<Integer> ySet = new HashSet<>();

            for (int[] stone : stones)
            {
                int x = stone[0];
                int y = stone[1];

                if (xSet.contains(x) || ySet.contains(y)) numOfStones++;

                xSet.add(x);
                ySet.add(y);
            }

            return numOfStones;
        }
    }
}
