package Strings;

public class SplitStringInBalancedStrings
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(solution.balancedStringSplit("RLRRRLLRLL"));
    }

    private static class Solution
    {
        public int balancedStringSplit(String s)
        {
            int numOfWays = 0;
            int operation = 0;
            int lngth = s.length();

            for (int i = 0; i < lngth; i++)
            {
                if (s.charAt(i) == 'R') operation++;
                else operation--;

                if (operation == 0) numOfWays++;
            }

            return numOfWays;
        }

        public int balancedStringSplit3(String s)
        {
            int numOfWays = 0;
            int balance = 0;
            int length = s.length();

            for (int i = 0; i < length; i++)
            {
                if (s.charAt(i) == 'R') balance++;
                else balance--;

                if (balance == 0) numOfWays++;
            }

            return numOfWays;
        }
    }
}
