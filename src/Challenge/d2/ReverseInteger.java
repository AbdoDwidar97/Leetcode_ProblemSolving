package Challenge.d2;

public class ReverseInteger
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
    }

    private static class Solution
    {
        public int reverse(int x)
        {
            long answer = 0;
            boolean isMinus = x < 0;
            x = Math.abs(x);

            while (x > 0)
            {
                int digit = x % 10;
                answer = (answer * 10) + digit;
                x /= 10;
            }

            if (isMinus) answer *= -1;
            if (answer > Math.pow(2, 31) - 1 || answer < Math.pow(-2, 31)) return 0;
            return (int) answer;
        }
    }
}
