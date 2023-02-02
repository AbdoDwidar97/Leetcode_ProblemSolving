package DynamicProgramming;

import java.util.HashMap;

public class IsSubsequence
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }

    private static class Solution
    {
        public boolean isSubsequence(String s, String t)
        {
            if (s.isEmpty()) return true;
            else if (t.isEmpty()) return false;

            int p = 0;
            char[] tArr = t.toCharArray();
            for (char chr : tArr)
            {
                if (chr == s.charAt(p)) p++;
                if (p == s.length()) return true;
            }

            return p == s.length();
        }
    }
}
