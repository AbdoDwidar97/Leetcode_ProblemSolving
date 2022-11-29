package Strings;

import java.util.*;

public class FindResultantArrayAfterRemovingAnagrams
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        List<String> res = solution.removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"});
        // List<String> res = solution.removeAnagrams(new String[]{"truqjvrb","vsuokmjq"});
        res.forEach(System.out::println);
    }

    private static class Solution
    {
        public List<String> removeAnagrams(String[] words)
        {
            ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));

            for (int i = 1; i < wordsList.size(); i++)
            {
                if (isAnagram(wordsList.get(i), wordsList.get(i - 1)))
                {
                    wordsList.remove(i);
                    i = 0;
                }
            }

            return wordsList;
        }

        private boolean isAnagram (String str1, String str2)
        {
            if (str1.length() != str2.length()) return false;

            HashMap<Character, Integer> str1Val = new HashMap<>();
            HashMap<Character, Integer> str2Val = new HashMap<>();

            for (int i = 0; i < str1.length(); i++)
            {
                if (str1Val.containsKey(str1.charAt(i))) str1Val.put(str1.charAt(i), str1Val.get(str1.charAt(i)) + 1);
                else str1Val.put(str1.charAt(i), 1);

                if (str2Val.containsKey(str2.charAt(i))) str2Val.put(str2.charAt(i), str2Val.get(str2.charAt(i)) + 1);
                else str2Val.put(str2.charAt(i), 1);
            }

            return str1Val.equals(str2Val);
        }
    }
}
