package Challenge.d4;

public class SearchInRotatedSortedArray
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(solution.search(new int[]{4,5,6,7,8,1,2,3}, 8));
    }

    private static class Solution
    {
        public int search(int[] nums, int target)
        {
            int start = 0, end = nums.length - 1;
            int middle = (end - start) / 2;
            while (end >= start)
            {
                if (start == end && nums[start] != target) return -1;
                if (nums[middle] == target) return middle;
                if (target == nums[start]) return start;
                if (target == nums[end]) return end;
                if (end == middle || start == middle) return -1;
                if (nums[middle] > nums[end])
                {
                    if ((target < nums[middle] && target < nums[end]) || (target > nums[middle] && target > nums[end]))
                    {
                        start = middle + 1;
                        end--;
                    }
                    else
                    {
                        end = middle - 1;
                        start++;
                    }
                }
                else if (nums[middle] < nums[start])
                {
                    if ((target < nums[middle] && target < nums[start]) || (target > nums[middle] && target > nums[start]))
                    {
                        end = middle - 1;
                        start++;
                    }
                    else
                    {
                        start = middle + 1;
                        end--;
                    }
                }
                else
                {
                    if (target < nums[middle])
                    {
                        end = middle - 1;
                        start++;
                    }
                    else
                    {
                        start = middle + 1;
                        end--;
                    }
                }

                middle = start + (end - start) / 2;
            }

            return -1;
        }
    }
}
