package Strings;

import java.util.HashSet;

public class UniqueMorseCodeWords
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));
    }

    private static class Solution
    {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        public int uniqueMorseRepresentations(String[] words)
        {
            HashSet<String> hashSet = new HashSet<>();

            for (int i = 0; i < words.length; i++)
            {
                hashSet.add(getMorse(words[i]));
            }

            return hashSet.size();
        }

        private String getMorse (String str)
        {
            String nStr = "";
            for (int i = 0; i < str.length(); i++)
            {
                nStr += morse[str.charAt(i) - 97];
            }

            return nStr;
        }
    }
}
