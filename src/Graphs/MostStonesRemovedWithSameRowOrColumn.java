package Graphs;

import java.util.HashMap;
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
        private HashMap<Integer, Integer> xMap = new HashMap<>();
        private HashMap<Integer, Integer> yMap = new HashMap<>();

        private int[] parents;
        public int removeStones(int[][] stones)
        {
            int numberOfComponents = stones.length;
            parents = new int[stones.length];
            for (int i = 0; i < parents.length; i++) parents[i] = i;

            for (int stoneIdx = 0; stoneIdx < stones.length; stoneIdx++)
            {
                int xStone = stones[stoneIdx][0];
                int yStone = stones[stoneIdx][1];

                if (!xMap.containsKey(xStone) && !yMap.containsKey(yStone))
                {
                    xMap.put(xStone, stoneIdx);
                    yMap.put(yStone, stoneIdx);
                }
                else if (xMap.containsKey(xStone) && yMap.containsKey(yStone))
                {
                    int xPoint = xMap.get(xStone);
                    int yPoint = yMap.get(yStone);

                    int xRoot = find(xPoint);
                    int yRoot = find(yPoint);

                    union(stoneIdx, xRoot);

                    if (xRoot == yRoot) numberOfComponents--;
                    else
                    {
                        numberOfComponents -= 2;
                        union(yRoot, xRoot);
                    }
                }
                else if (xMap.containsKey(xStone))
                {
                    yMap.put(yStone, stoneIdx);
                    int xPoint = xMap.get(xStone);
                    int xRoot = find(xPoint);
                    numberOfComponents--;
                    union(stoneIdx, xRoot);
                }
                else
                {
                    xMap.put(xStone, stoneIdx);
                    int yPoint = yMap.get(yStone);
                    int yRoot = find(yPoint);
                    numberOfComponents--;
                    union(stoneIdx, yRoot);
                }
            }

            return stones.length - numberOfComponents;
        }

        private int find(int pointIdx)
        {
            if (pointIdx == parents[pointIdx]) return parents[pointIdx];
            return find(parents[pointIdx]);
        }

        private void union(int pointIdx, int parentIdx)
        {
            int pointRoot = find(pointIdx);
            int parentRoot = find(parentIdx);

            parents[pointRoot] = parentRoot;
        }
    }
}
