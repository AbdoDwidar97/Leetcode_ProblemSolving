package Challenge.d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Sum4
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // List<List<Integer>> res = solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        List<List<Integer>> res = solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8);

        for (List<Integer> lst : res)
        {
            lst.forEach(System.out::println);
            System.out.println("-----");
        }
    }

    private static class Solution
    {
        public List<List<Integer>> fourSum(int[] nums, int target)
        {
            List<List<Integer>> answer = new ArrayList<>();
            HashSet<String> hs = new HashSet<>();

            for (int a = 0; a < nums.length; a++)
            {
                for (int b = a + 1; b < nums.length; b++)
                {
                    for (int c = b + 1; c < nums.length; c++)
                    {
                        for (int d = c + 1; d < nums.length; d++)
                        {
                            if (nums[a] + nums[b] + nums[c] + nums[d] == target)
                            {
                                ArrayList<Integer> al = new ArrayList<>(List.of(nums[a], nums[b], nums[c], nums[d]));
                                Collections.sort(al);

                                String bfr = "";
                                for (Integer itr : al)
                                {
                                    bfr += itr.toString();
                                    bfr += " ";
                                }

                                bfr = bfr.trim();
                                if (!hs.contains(bfr))
                                {
                                    answer.add(al);
                                    hs.add(bfr);
                                }
                            }

                        }
                    }
                }
            }

            return answer;
        }
    }
}
