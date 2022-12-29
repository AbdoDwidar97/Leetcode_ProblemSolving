package Strings;

public class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome2("babad"));
        System.out.println(solution.longestPalindrome2("cbbd"));
        System.out.println(solution.longestPalindrome2("abb"));

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

        /// -----------------------------------------------------------------

        public String longestPalindrome2(String s)
        {
            int st = 0, end = 0;
            for (int i = 0; i < s.length(); i++)
            {
                int ln1 = spreadFromCenter(s, i, i); /// for odd strings.
                int ln2 = spreadFromCenter(s, i, i + 1); /// for even strings.

                int ln = Math.max(ln1, ln2);

                if (ln > end - st)
                {
                    st = i - (ln - 1) / 2;
                    end = i + ln / 2;
                }
            }

            return s.substring(st, end + 1);
        }

        private int spreadFromCenter(String s, int start, int end)
        {
            int left = start;
            int right = end;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }

            return right - left - 1;
        }
    }
}
