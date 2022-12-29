package Strings;

public class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("abb"));

        // System.out.println(solution.checkPalindrome("l"));
    }

    private static class Solution
    {
        public String longestPalindrome(String s)
        {
            if (checkPalindrome(s)) return s;

            String longestPalindromeString = "";

            int lngth = s.length() - 1;

            for (int i = 0; i <= lngth; i++)
            {
                for (int j = i + 1; j <= lngth + 1; j++)
                {
                    String str = s.substring(i, j);
                    if (checkPalindrome(str) && str.length() > longestPalindromeString.length())
                        longestPalindromeString = str;
                }
            }

            return longestPalindromeString;
        }

        private boolean checkPalindrome(String s)
        {
            int lngth = s.length() - 1;

            for (int i = 0; i <= lngth / 2; i++)
            {
                if (s.charAt(i) != s.charAt(lngth - i)) return false;
            }

            return true;
        }
    }
}
