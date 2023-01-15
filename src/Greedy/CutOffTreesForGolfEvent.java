package Greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CutOffTreesForGolfEvent
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // List<List<Integer>> lst = new ArrayList<>(List.of(List.of(2,3,4), List.of(0,0,5), List.of(8,7,6)));
        List<List<Integer>> lst = new ArrayList<>(List.of(
                List.of(54581641,64080174,24346381,69107959),
                List.of(86374198,61363882,68783324,79706116),
                List.of(668150,92178815,89819108,94701471),
                List.of(83920491,22724204,46281641,47531096),
                List.of(89078499,18904913,25462145,60813308)
        ));
        System.out.println(solution.cutOffTree(lst));
    }

    private static class Solution {
        private HashSet<Integer> accessedX = new HashSet<>();
        private HashSet<Integer> accessedY = new HashSet<>();

        public int cutOffTree(List<List<Integer>> forest)
        {
            int minSteps = dfsMinSteps(forest, 0, 0, forest.get(0).get(0), 0, new boolean[forest.size()][forest.get(0).size()]);
            if (minSteps == Integer.MAX_VALUE || accessedX.size() != forest.get(0).size() || accessedY.size() != forest.size()) return -1;

            return minSteps;
        }

        private int dfsMinSteps(List<List<Integer>> forest, int currentX, int currentY, int parent, int level, boolean[][] visited)
        {
            if (currentX >= forest.get(0).size() ||
                    currentX < 0 ||
                    currentY >= forest.size() ||
                    currentY < 0) return Integer.MAX_VALUE;

            if (visited[currentY][currentX] ||
                    forest.get(currentY).get(currentX) == 0 ||
                    parent > forest.get(currentY).get(currentX)) return Integer.MAX_VALUE;

            visited[currentY][currentX] = true;
            accessedX.add(currentX);
            accessedY.add(currentY);

            int left = dfsMinSteps(forest, currentX - 1, currentY, forest.get(currentY).get(currentX), level + (forest.get(currentY).get(currentX) - parent), visited);
            int right = dfsMinSteps(forest, currentX + 1, currentY, forest.get(currentY).get(currentX), level + (forest.get(currentY).get(currentX) - parent), visited);

            int up = dfsMinSteps(forest, currentX, currentY - 1, forest.get(currentY).get(currentX), level + (forest.get(currentY).get(currentX) - parent), visited);
            int down = dfsMinSteps(forest, currentX, currentY + 1, forest.get(currentY).get(currentX), level + (forest.get(currentY).get(currentX) - parent), visited);

            visited[currentY][currentX] = false;

            if (left == right && right == up && up == down && down == Integer.MAX_VALUE) return level + (forest.get(currentY).get(currentX) - parent);
            return Math.min(Math.min(left, up), Math.min(right, down));
        }
    }
}

