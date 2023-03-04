package DynamicProgramming;

public class CountSortedVowelStrings
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.countVowelStrings(33));
    }

    private static class Solution
    {
        public int countVowelStrings(int n)
        {
            char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
            return dfsCountVowels(n, vowels, 0);
        }

        private int dfsCountVowels(int n, char[] vowels, int start)
        {
            if (n == 0) return 1;

            int count = 0;
            for (int i = start; i < 5; i++)
            {
                count += dfsCountVowels(n - 1, vowels, i);
            }

            return count;
        }
    }
}
