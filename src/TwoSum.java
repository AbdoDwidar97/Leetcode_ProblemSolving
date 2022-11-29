import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    public static void main(String []args)
    {
        // int[] result = twoSum2(new int[]{2,7,11,15}, 9);
        // int[] result = twoSum2(new int[]{3,2,4}, 6);
        int[] result = twoSum2(new int[]{3,3}, 6);
        Arrays.stream(result).forEach(System.out::println);
    }

    // Getting Two sum with O(n sqr) complexity
    public static int[] twoSum(int[] nums, int target)
    {
        for (int idx = 0; idx < nums.length; idx++)
        {
            for (int idx2 = idx + 1; idx2 < nums.length; idx2++)
            {
                if (nums[idx] + nums[idx2] == target) return new int [] {idx, idx2};
            }
        }

        return new int []{};
    }

    public static int[] twoSum2(int[] nums, int target)
    {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (numMap.containsKey(target - nums[i]) && i != numMap.get(target - nums[i]))
                return new int []{i, numMap.get(target - nums[i])};
        }

        return new int[]{};
    }

}
