package Greedy;

import java.util.*;

public class MinimumSubsequenceInNonIncreasingOrder
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        //List<Integer> res = solution.minSubsequence(new int[]{4,3,10,9,8});
        List<Integer> res = solution.minSubsequence(new int[]{8,8});
        res.forEach(System.out::println);
    }

    private static class Solution
    {
        public List<Integer> minSubsequence(int[] nums)
        {
            List<Integer> result = new ArrayList<>();

            Arrays.sort(nums);

            int allSum = 0;
            for (int num : nums) allSum += num;

            int selectedSums = 0;
            int p = nums.length - 1;
            while (p >= 0)
            {
                if (selectedSums > allSum / 2) break;
                selectedSums += nums[p];
                result.add(nums[p]);
                p--;
            }

            return result;
        }
    }
}
