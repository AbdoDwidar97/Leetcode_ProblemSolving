package Graphs;

import java.security.Key;
import java.util.Collections;
import java.util.HashMap;

public class FindCenterOfStarGraph
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.findCenter2(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }

    private static class Solution
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        public int findCenter(int[][] edges)
        {
            int maxKey = 0;
            int maxValue = 0;

            for (int i = 0; i < edges.length; i++)
            {
                int u = edges[i][0];
                int v = edges[i][1];

                if (map.containsKey(u)) map.put(u, map.get(u) + 1);
                else map.put(u, 1);

                if (map.get(u) > maxValue)
                {
                    maxKey = u;
                    maxValue = map.get(u);
                }

                if (map.containsKey(v)) map.put(v, map.get(v) + 1);
                else map.put(v, 1);

                if (map.get(v) > maxValue)
                {
                    maxKey = v;
                    maxValue = map.get(v);
                }
            }

            return maxKey;
        }

        /// Supersonic way
        public int findCenter2(int[][] edges)
        {
            int u = edges[0][0];
            int v = edges[0][1];

            if (v == edges[1][0] || v == edges[1][1]) return v;
            else return u;
        }
    }

}
