package Strings;

public class SortingTheSentence
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.sortSentence("is2 sentence4 This1 a3"));
    }

    private static class Solution
    {
        public String sortSentence(String s)
        {
            String[] phrase = s.split(" ");
            String[] newPhrase = new String[phrase.length];

            for (int i = 0; i < phrase.length; i++)
            {
                int idx = Integer.parseInt(phrase[i].charAt(phrase[i].length() - 1) + "") - 1;
                newPhrase[idx] = phrase[i].substring(0, phrase[i].length() - 1);
            }

            String sorted = "";
            for (int i = 0; i < newPhrase.length; i++)
            {
                if (i == newPhrase.length - 1) sorted += newPhrase[i];
                else sorted += newPhrase[i] + " ";
            }

            return sorted;
        }
    }
}
