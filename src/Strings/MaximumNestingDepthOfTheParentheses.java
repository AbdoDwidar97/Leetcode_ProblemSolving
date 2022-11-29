package Strings;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));
    }

    private static class Solution
    {
        public int maxDepth(String s)
        {
            int maxDepth = 0;
            Stack<Character> brackets = new Stack<>();

            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == '(')
                {
                    brackets.push('(');
                    if (brackets.size() > maxDepth) maxDepth = brackets.size();
                }
                else if (s.charAt(i) == ')')
                {
                    brackets.pop();
                }
            }

            return maxDepth;
        }
    }
}
