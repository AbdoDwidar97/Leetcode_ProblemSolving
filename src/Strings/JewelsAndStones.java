package Strings;

public class JewelsAndStones
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int res = solution.numJewelsInStones("aA", "aAAbbbb");
        System.out.println(res);
    }

    private static class Solution
    {
        public int numJewelsInStones(String jewels, String stones)
        {
            int numberOfStones = 0;
            int jewelIdx = 0;
            while (jewelIdx < jewels.length())
            {
                for (int i = 0; i < stones.length(); i++)
                {
                    if (jewels.charAt(jewelIdx) == stones.charAt(i)) numberOfStones++;
                }

                jewelIdx++;
            }

            return numberOfStones;
        }
    }
}
