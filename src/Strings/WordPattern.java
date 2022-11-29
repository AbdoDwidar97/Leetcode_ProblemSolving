package Strings;

import java.util.HashMap;

public class WordPattern
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
    }

    private static class Solution
    {
        public boolean wordPattern(String pattern, String s)
        {
            String[] words = s.split(" ");
            int patternLength = pattern.length();

            if (patternLength != words.length) return false;

            HashMap<Character, Integer> patternCharPosition = new HashMap<>();
            HashMap<String, Integer> patternWordPosition = new HashMap<>();

            int [] patternModel = new int[patternLength];
            int [] patternWordModel = new int[patternLength];

            for (int i = 0; i < patternLength; i++)
            {
                if (!patternCharPosition.containsKey(pattern.charAt(i)))
                    patternCharPosition.put(pattern.charAt(i), i);

                if (!patternWordPosition.containsKey(words[i]))
                    patternWordPosition.put(words[i], i);

                patternModel[i] = patternCharPosition.get(pattern.charAt(i));
                patternWordModel[i] = patternWordPosition.get(words[i]);
            }

            for (int i = 0; i < patternLength; i++)
            {
                if (patternWordModel[i] != patternModel[i]) return false;
            }

            return true;
        }
    }
}
