package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ConcatenationOfArray
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int [] res = solution.getConcatenation(new int[]{1, 2, 1});
        Arrays.stream(res).forEach(System.out::println);
    }

    private static class Solution
    {
        public int[] getConcatenation(int[] nums)
        {
            int[] res = new int[nums.length * 2];

            int times = 0;
            while (times < 2)
            {
                for (int i = 0; i < nums.length; i++)
                {
                    res[i + (times * nums.length)] = nums[i];
                }

                times++;
            }

            return res;
        }
    }
}

