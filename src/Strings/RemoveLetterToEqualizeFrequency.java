package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RemoveLetterToEqualizeFrequency
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.equalFrequency2("abcc"));
        System.out.println(solution.equalFrequency2("aazz"));
        System.out.println(solution.equalFrequency2("bbac"));
        System.out.println(solution.equalFrequency2("bac"));
    }

    private static class Solution
    {
        public boolean equalFrequency(String word)
        {
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Integer, Integer> common = new HashMap<>();

            for (int i = 0; i < word.length(); i++)
            {
                if (map.containsKey(word.charAt(i))) map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
                else map.put(word.charAt(i), 1);
            }

            List<Integer> values = map.values().stream().toList();

            for (int val : values)
            {
                if (common.containsKey(val)) common.put(val, common.get(val) + 1);
                else common.put(val, 1);
            }

            int maxValue = 0;
            int maxKey = 0;

            List<Integer> commonValues = common.values().stream().toList();

            for (int i = 0; i < commonValues.size(); i++)
            {
                if (commonValues.get(i) > maxValue)
                {
                    maxKey = i;
                    maxValue = commonValues.get(i);
                }
            }

            int expectedSum = common.keySet().stream().toList().get(maxKey) * map.size();
            int realSum = map.values().stream().reduce(Integer::sum).get();

            int diff = Math.abs(expectedSum - realSum);

            if (diff == 0) return false;
            if (diff == 1) return true;
            else return false;
        }

        /// ------------------ Dumb way ------------------------------

        public boolean equalFrequency2(String word)
        {
            for (int i = 0; i < word.length(); i++)
            {
                if (validate(word, i)) return true;
            }

            return false;
        }

        private boolean validate(String word, int idx)
        {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < word.length(); i++)
            {
                if (i != idx)
                {
                    if (map.containsKey(word.charAt(i))) map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
                    else map.put(word.charAt(i), 1);
                }
            }

            List<Integer> values = map.values().stream().toList();

            for (int i = 1; i < values.size(); i++)
            {
                if (values.get(i) != values.get(i - 1)) return false;
            }

            return true;
        }
    }
}
