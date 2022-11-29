package Arrays;

import java.util.Arrays;

public class RunningSumOf1DArray
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int [] res = solution.runningSum(new int[]{1,2,3,4});
        Arrays.stream(res).forEach(System.out::println);
    }

    private static class Solution
    {
        public int[] runningSum(int[] nums)
        {
            int [] res = new int[nums.length];
            res[0] = nums[0];

            for (int i = 1; i < nums.length; i++)
            {
                res[i] = res[i - 1] + nums[i];
            }

            return res;
        }
    }
}
