package MockInterview;

import java.util.HashSet;

public class D2
{
    public static void main(String[] args)
    {
        /*Solution solution = new Solution();
        System.out.println(solution.checkRecord("PPALLP"));
        System.out.println(solution.checkRecord("PPALLL"));*/

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(solution2.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));
        System.out.println(solution2.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
        System.out.println(solution2.networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
    }

    private static class Solution
    {
        public boolean checkRecord(String s)
        {
            int a = 0, l = 0;
            int lnth = s.length();
            for (int i = 0; i < lnth; i++)
            {
                switch (s.charAt(i))
                {
                    case 'A':
                        a++;
                        l = 0;
                        if (a > 1) return false;
                        break;

                    case 'L':
                        l++;
                        if (l > 2) return false;
                        break;

                    default:
                        l = 0;
                        break;
                }
            }

            return true;
        }
    }

    private static class Solution2
    {
        HashSet<Integer> hashSet = new HashSet<>();
        public int networkDelayTime(int[][] times, int n, int k)
        {
            hashSet.clear();
            int res = traverse(times, k, 0);
            if (res == 0) return -1;
            else return res;
        }

        private int traverse(int[][] times, int k, int length)
        {
            if (hashSet.contains(k)) return 0;
            hashSet.add(k);

            int maxLength = length;
            boolean isChild = false;
            for (int i = 0; i < times.length; i++)
            {
                if (times[i][0] == k)
                {
                    isChild = true;
                    maxLength = Math.max(maxLength, traverse(times, times[i][1], length + times[i][2]));
                }
            }

            if (isChild) return maxLength;
            else return length;
        }
    }

}
