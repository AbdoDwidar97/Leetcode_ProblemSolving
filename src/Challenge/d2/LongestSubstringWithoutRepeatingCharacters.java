package Challenge.d2;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abba"));
        System.out.println(solution.lengthOfLongestSubstring("a"));
    }

    private static class Solution
    {
        public int lengthOfLongestSubstring(String s)
        {
            if (s.isEmpty()) return 0;
            if (s.length() == 1) return 1;
            int answer = 0;
            char[] chars = s.toCharArray();

            HashSet<Character> repeated = new HashSet<>();
            repeated.add(chars[0]);

            int start = 0, end = start + 1;
            while (start < end)
            {
                if (repeated.contains(chars[end]))
                {
                    repeated.remove(chars[start]);
                    answer = Math.max(answer, end - start);
                    start++;
                    if (start == end && end < chars.length - 1)
                    {
                        repeated.add(chars[end]);
                        end++;
                    }
                }
                else if (end == chars.length - 1) return Math.max(answer, end - start + 1);
                else
                {
                    repeated.add(chars[end]);
                    end++;
                }
            }

            return answer;
        }
    }
}
