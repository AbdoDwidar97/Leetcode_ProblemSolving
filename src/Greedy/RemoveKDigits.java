package Greedy;

import java.util.Stack;

public class RemoveKDigits
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
        System.out.println(solution.removeKdigits("10200", 1));
        System.out.println(solution.removeKdigits("10", 2));
        System.out.println(solution.removeKdigits("1107", 1));
        System.out.println(solution.removeKdigits("10001", 1));
        System.out.println(solution.removeKdigits("112", 1));
    }

    private static class Solution
    {
        public String removeKdigits(String num, int k)
        {
            if (num.length() == k) return "0";

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < num.length(); i++)
            {
                if (stack.size() == 1 && stack.peek() == 0) stack.pop();

                int digit = Integer.parseInt(num.charAt(i) + "");
                if (k == 0 || stack.isEmpty()) stack.add(digit);
                else
                {
                    while (!stack.isEmpty() && k > 0 && digit < stack.peek())
                    {
                        stack.pop();
                        k--;
                    }

                    stack.add(digit);
                }
            }

            while (k > 0 && !stack.isEmpty())
            {
                stack.pop();
                k--;
            }

            String result = "";

            if (stack.isEmpty()) return "0";
            while (!stack.isEmpty()) result = stack.pop() + result;

            return result;
        }
    }
}
