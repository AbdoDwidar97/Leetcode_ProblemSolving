package Strings;

import java.util.Stack;

public class ValidParentheses
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
    }

    private static class Solution
    {
        public boolean isValid(String s)
        {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++)
            {
                switch (s.charAt(i))
                {
                    case '(':
                        stack.push('(');
                        break;

                    case '[':
                        stack.push('[');
                        break;

                    case '{':
                        stack.push('{');
                        break;

                    case ')':
                        if (stack.isEmpty() || stack.peek() != '(') return false;
                        stack.pop();
                        break;

                    case ']':
                        if (stack.isEmpty() || stack.peek() != '[') return false;
                        stack.pop();
                        break;

                    case '}':
                        if (stack.isEmpty() || stack.peek() != '{') return false;
                        stack.pop();
                        break;

                    default:
                        return false;
                }
            }

            return stack.isEmpty();
        }
    }
}
