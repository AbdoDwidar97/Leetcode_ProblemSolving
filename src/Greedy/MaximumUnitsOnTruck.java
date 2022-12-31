package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumUnitsOnTruck
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // System.out.println(solution.maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10));
        System.out.println(solution.maximumUnits(new int[][]{{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}}, 35));
    }

    private static class Solution
    {
        public int maximumUnits(int[][] boxTypes, int truckSize)
        {
            int maxUnits = 0;

            PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    if (o1[1] < o2[1]) return 1;
                    else if (o1[1] > o2[1]) return -1;
                    else {
                        if (o1[0] < o2[0]) return 1;
                        else if (o1[0] > o2[0]) return -1;
                    }

                    return 0;
                }
            });

            for (int[] boxType : boxTypes) maxHeap.add(new Integer[]{boxType[0], boxType[1]});

            while (truckSize > 0)
            {
                if (maxHeap.isEmpty()) break;

                Integer[] box = maxHeap.poll();
                int remain = truckSize - box[0];
                if (remain >= 0)
                {
                    maxUnits += box[0] * box[1];
                    truckSize = remain;
                }
                else
                {
                    maxUnits += (remain + box[0]) * box[1];
                    break;
                }
            }

            return maxUnits;
        }
    }
}
