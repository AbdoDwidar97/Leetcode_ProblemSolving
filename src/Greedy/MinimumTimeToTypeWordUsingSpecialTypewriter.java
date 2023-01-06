package Greedy;

public class MinimumTimeToTypeWordUsingSpecialTypewriter
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.minTimeToType("zjpc"));
    }

    private static class Solution
    {
        public int minTimeToType(String word)
        {
            int minNumOfTime = 0;

            char currentchr = 'a';
            int lngth = word.length();
            for (int i = 0; i < lngth; i++)
            {
                int distance = Math.abs((int) currentchr - (int) word.charAt(i));
                if (distance <= 13) minNumOfTime += distance;
                else minNumOfTime += 26 - distance;

                minNumOfTime++;
                currentchr = word.charAt(i);
            }

            return minNumOfTime;
        }
    }
}
