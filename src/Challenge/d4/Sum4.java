package Challenge.d4;

import java.util.ArrayList;
import java.util.List;

public class Sum4
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0);

        for (List<Integer> lst : res)
        {
            lst.forEach(System.out::println);
            System.out.println("-----");
        }
    }

    private static class Solution
    {
        private List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> fourSum(int[] nums, int target)
        {
            dfsTraverseSums(nums, 0, target, 0, new ArrayList<>());
            return answer;
        }

        private void dfsTraverseSums(int[] nums, int pos, int target, int sum, List<Integer> lst)
        {
            if (lst.size() == 4)
            {
                if (sum == target) answer.add(lst);
                return;
            }

            for (int i = pos; i < nums.length; i++)
            {
                List<Integer> myLst = new ArrayList<>(lst);
                myLst.add(nums[i]);
                dfsTraverseSums(nums, pos + 1, target, sum + nums[i], myLst);
            }
        }
    }
}
