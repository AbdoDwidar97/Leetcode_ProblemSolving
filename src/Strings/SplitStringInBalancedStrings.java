package Strings;

public class SplitStringInBalancedStrings
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.balancedStringSplit3("RLRRLLRLRL"));
        System.out.println(solution.balancedStringSplit3("RLRRRLLRLL"));
    }

    private static class Solution
    {
        public int balancedStringSplit(String s)
        {
            int maxNumOfStrings = 0;
            String buffer = "";
            for (int i = 1; i < s.length(); i+=2)
            {
                buffer += s.charAt(i)  + "" + s.charAt(i - 1);

                if (checkBalance(buffer))
                {
                    maxNumOfStrings++;
                    buffer = "";
                }
            }

            return maxNumOfStrings;
        }

        private boolean checkBalance(String str)
        {
            int numOfR = 0, numOfL = 0;
            for (int i = 0; i < str.length(); i++)
            {
                if (str.charAt(i) == 'R') numOfR++;
                else numOfL++;
            }

            return numOfR == numOfL;
        }

        // --------------------- Super-Sonic Way (WRONG) ---------------------------

        // private int numOfWays = 0;
        /*public int balancedStringSplit2(String s)
        {
            numOfWays = 0;
            divideAndConquer(s);
            return numOfWays;
        }*/

        /*private String divideAndConquer(String str)
        {
            int length = str.length();
            if (length == 1) return str;

            String left = divideAndConquer(str.substring(0, length / 2));
            String right = divideAndConquer(str.substring(length / 2));

            return merge(left, right);
        }*/

        /*private String merge(String left, String right)
        {
            int balance = 0;
            String newStr = "";

            for (int i = 0; i < left.length(); i++)
            {
                char myChar = left.charAt(i);
                newStr += myChar;
                if (myChar == 'R') balance++;
                else if (myChar == 'L') balance--;
                else balance = 0;
            }

            for (int i = 0; i < right.length(); i++)
            {
                char myChar = right.charAt(i);
                newStr += myChar;
                if (myChar == 'R') balance++;
                else if (myChar == 'L') balance--;
                else if (myChar != ' ' && i != right.length() - 1) balance = 0;
            }

            if (balance == 0)
            {
                numOfWays++;
                return " ";
            }

            else return newStr;
        }*/

        // --------------- Super Fast ----------------------------------------


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
