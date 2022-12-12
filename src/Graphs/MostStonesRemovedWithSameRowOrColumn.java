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
            if (stones.length == 1) return 0;

            int maxRemoves = 0;
            for (int i = 0; i < stones.length; i++)
            {
                int[] currentStone = stones[i];
                for (int j = i + 1; j < stones.length; j++)
                {
                    int[] otherStone = stones[j];

                    if (currentStone[0] == otherStone[0] || currentStone[1] == otherStone[1]) maxRemoves++;
                }
            }

            return maxRemoves - 1;
        }
    }
}
