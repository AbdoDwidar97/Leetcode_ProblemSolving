package DynamicProgramming;

public class DivisorGame
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.divisorGame(2));
        System.out.println(solution.divisorGame(3));
    }

    private static class Solution
    {
        public boolean divisorGame(int n)
        {
            int aliceTry = 0;
            while (n > 1)
            {
                aliceTry++;
                for (int i = 1; i < n; i++)
                {
                    if (n % i == 0)
                    {
                        n = n - i;
                        i = n;
                    }
                }
            }

            return aliceTry % 2 == 1;
        }
    }

}
