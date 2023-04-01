package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class CountSubstringsThatDifferByOneCharacter
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("aba", "baba"));
    }

    private static class Solution
    {
        public int countSubstrings(String s, String t)
        {
            int numOfSubStrings = 0;
            HashMap<String, Integer> sMap = new HashMap<>();
            HashMap<String, Integer> tMap = new HashMap<>();

            splitWord(t, tMap);
            splitWord(s, sMap);

            for (String tStr : tMap.keySet())
            {
                for (String sStr : sMap.keySet())
                {
                    if (sStr.length() == tStr.length())
                    {
                        if (isWordsDiffByOne(sStr, tStr)) numOfSubStrings += (sMap.get(sStr) * tMap.get(tStr));
                    }
                }
            }

            return numOfSubStrings;
        }

        private void splitWord(String str, HashMap<String, Integer> baseMap)
        {
            char[] arr = str.toCharArray();
            String buffer = "";
            for (int i = 0; i < arr.length; i++)
            {
                buffer = "";
                for (int j = i; j < arr.length; j++)
                {
                    buffer += "" + arr[j];
                    if (baseMap.containsKey(buffer)) baseMap.put(buffer, baseMap.get(buffer) + 1);
                    else baseMap.put(buffer, 1);
                }
            }
        }

        private boolean isWordsDiffByOne(String w1, String w2)
        {
            int diff = 0;
            int lngth = w1.length();
            for (int i = 0; i < lngth; i++)
            {
                if (w1.charAt(i) != w2.charAt(i)) diff++;
                if (diff > 1) return false;
            }

            return diff == 1;
        }
    }
}
