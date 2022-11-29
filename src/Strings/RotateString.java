package Strings;

public class RotateString
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.rotateString("abcde", "cdeab"));
        System.out.println(solution.rotateString("abcde", "abced"));

        System.out.println(solution.rotateString("gcmbf", "fgcmb"));
        System.out.println(solution.rotateString("aa", "a"));

    }

    private static class Solution
    {
        public boolean rotateString(String s, String goal)
        {
            if (s.length() != goal.length()) return false;

            char startChar = goal.charAt(0);

            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == startChar && goal.equals(operate(s, i))) return true;
            }

            return false;
        }

        private String operate(String s, int position)
        {
            String left = s.substring(0, position);
            String right = s.substring(position);

            return right + left;
        }
    }

}
