package Arrays;

import java.util.Arrays;

public class BuildArrayFromPermutation
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] res = solution.buildArray(new int[]{0,2,1,5,3,4});
        Arrays.stream(res).forEach(System.out::println);
    }

    private static class Solution
    {
        public int[] buildArray(int[] nums)
        {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++)
            {
                res[i] = nums[nums[i]];
            }

            return res;
        }
    }
}
