package Greedy;

public class MinimumNumberOfOperationsToConvertTime
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.convertTime("02:30", "04:35"));
    }

    private static class Solution
    {
        public int convertTime(String current, String correct)
        {
            int minOperations = 0;

            int cur = (Integer.parseInt(current.substring(0, 2)) * 60) + Integer.parseInt(current.substring(3));
            int cor = (Integer.parseInt(correct.substring(0, 2)) * 60) + Integer.parseInt(correct.substring(3));

            int duration = cor - cur;

            while (duration > 0)
            {
                if (duration >= 60)
                {
                    int numOfHours = duration / 60;
                    minOperations += numOfHours;
                    duration -= (numOfHours * 60);
                }
                else if (duration >= 15)
                {
                    int numOfQuarters = duration / 15;
                    minOperations += numOfQuarters;
                    duration -= (numOfQuarters * 15);
                }
                else if (duration >= 5)
                {
                    int numOf5Mins = duration / 5;
                    minOperations += numOf5Mins;
                    duration -= (numOf5Mins * 5);
                }
                else
                {
                    minOperations += duration;
                    break;
                }

            }

            return minOperations;
        }
    }
}
