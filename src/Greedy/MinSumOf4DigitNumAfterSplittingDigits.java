package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinSumOf4DigitNumAfterSplittingDigits
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // System.out.println(solution.minimumSum(2932));
        System.out.println(solution.minimumSum(4009));
    }

    private static class Solution
    {
        public int minimumSum(int num)
        {
            int[] nums = new int[4];

            int number = num;

            int itr = 3;
            while (itr >= 0)
            {
                nums[itr] = number % 10;
                number /= 10;
                itr--;
            }

            Arrays.sort(nums);

            int num1 = nums[0] * 10 + nums[2];
            int num2 = nums[1] * 10 + nums[3];

            return num1 + num2;
        }
    }
}
