package Strings;
import java.util.HashMap;
import java.util.Set;

public class ValidPalindromeII
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("aaabaaa"));
    }

    private static class Solution
    {
        public boolean validPalindrome(String s)
        {
            int pointer1 = 0;
            int pointer2 = s.length() - 1;

            for (int i = 0; i < s.length() / 2; i++)
            {
                if (s.charAt(pointer1) != s.charAt(pointer2))
                {
                    return check(s, pointer1) || check(s, pointer2);
                }

                pointer1++;
                pointer2--;
            }

            return true;
        }

        private boolean check (String s, int ignorePoint)
        {
            int pointer1 = 0;
            int pointer2 = s.length() - 1;

            for (int i = 0; i < s.length() / 2; i++)
            {
                if (ignorePoint == pointer1) pointer1++;
                if (ignorePoint == pointer2) pointer2--;

                if (s.charAt(pointer1) != s.charAt(pointer2)) return false;
                pointer1++;
                pointer2--;

            }

            return true;
        }
    }
}
