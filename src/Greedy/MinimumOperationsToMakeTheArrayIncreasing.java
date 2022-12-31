package Greedy;

public class MinimumOperationsToMakeTheArrayIncreasing
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1,5,2,4,1}));
        System.out.println(solution.minOperations(new int[]{1,1,1}));
    }

    private static class Solution
    {
        public int minOperations(int[] nums)
        {
            int diff = 0;

            for (int i = 1; i < nums.length; i++)
            {
                if (nums[i - 1] >= nums[i])
                {
                    int newNum = nums[i - 1] + 1;
                    diff += newNum - nums[i];
                    nums[i] = newNum;
                }
            }

            return diff;
        }
    }
}
