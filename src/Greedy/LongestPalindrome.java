package Greedy;

public class LongestPalindrome
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("a"));
    }

    private static class Solution
    {
        public int longestPalindrome(String s)
        {
            if (s.length() == 1) return 1;

            int longestPalindrome = 0;
            for (int i = 0; i < s.length(); i++)
            {
                int evenCase = checkPalindromeFromMiddle(s, i, i + 1);
                int oddCase = checkPalindromeFromMiddle(s, i, i);

                longestPalindrome = Math.max(longestPalindrome, Math.max(evenCase, oddCase));
            }

            return longestPalindrome + 1;
        }

        private int checkPalindromeFromMiddle(String s, int left, int right)
        {
            if (left > right) return 0;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }

            return right - left + 1;
        }

    }
}