package Strings;

public class MaximumNumberOfWordsFoundInSentences
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int res = solution.mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"});
        System.out.println(res);
    }

    private static class Solution
    {
        public int mostWordsFound(String[] sentences)
        {
            int maxNum = sentences[0].split(" ").length;

            for (int i = 1; i < sentences.length; i++)
            {
                int numOfWords = sentences[i].split(" ").length;
                if (numOfWords >= maxNum) maxNum = numOfWords;
            }

            return maxNum;
        }
    }
}
