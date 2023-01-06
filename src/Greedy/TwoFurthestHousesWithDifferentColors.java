package Greedy;

public class TwoFurthestHousesWithDifferentColors
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(new int[]{1,1,1,6,1,1,1}));
    }

    private static class Solution
    {
        public int maxDistance(int[] colors)
        {
            int maxDistance = 0;

            for (int i = 0; i < colors.length; i++)
            {
                if (colors[i] != colors[colors.length - 1])
                {
                    maxDistance = (colors.length - 1) - i;
                    break;
                }
            }

            for (int i = colors.length - 1; i >= 0; i--)
            {
                if (colors[0] != colors[i])
                {
                    maxDistance = Math.max(maxDistance, i);
                    break;
                }
            }

            return maxDistance;
        }
    }
}
