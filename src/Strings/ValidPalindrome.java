package Strings;

public class ValidPalindrome
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("0P"));
        System.out.println(solution.isPalindrome("a."));
    }

    private static class Solution
    {
        public boolean isPalindrome(String s)
        {
            s = s.toLowerCase();
            int pointer1 = 0;
            int pointer2 = s.length() - 1;

            while (pointer2 > pointer1)
            {
                if (!(s.charAt(pointer1) >= 97 && s.charAt(pointer1) <= 122) && !(s.charAt(pointer1) >= 48 && s.charAt(pointer1) <= 57))
                {
                    pointer1++;
                }
                else if (!((s.charAt(pointer2) >= 97 && s.charAt(pointer2) <= 122)) && !(s.charAt(pointer2) >= 48 && s.charAt(pointer2) <= 57))
                {
                    pointer2--;
                }
                else
                {
                    if (s.charAt(pointer1) != s.charAt(pointer2)) return false;

                    pointer1++;
                    pointer2--;
                }
            }

            return true;
        }
    }

}
