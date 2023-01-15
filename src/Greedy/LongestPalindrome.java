package Greedy;

import java.util.HashMap;

public class LongestPalindrome
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        //System.out.println(solution.longestPalindrome("abccccdd"));
        //System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    private static class Solution
    {
        public int longestPalindrome(String s)
        {
            /// Characters degree way -> Super fast way
            int longestPalindrome = 0;
            HashMap<Character, Integer> charsDegree = new HashMap<>();

            for (int i = 0; i < s.length(); i++)
            {
                char chr = s.charAt(i);
                if (charsDegree.containsKey(chr)) charsDegree.put(chr, charsDegree.get(chr) + 1);
                else charsDegree.put(chr, 1);
            }

            int maxOdd = 0;
            for (int degree : charsDegree.values())
            {
                if (degree % 2 == 0) longestPalindrome += degree;
                else maxOdd = Math.max(maxOdd, degree);
            }

            return longestPalindrome + maxOdd;
        }

        /// DFS Way -> Inefficient
        private int dfsFindLongestPalindrome(String s, String buffer)
        {
            int longestPalindrome = 0;
            if (isPalindrome(buffer)) longestPalindrome = buffer.length();

            for (int i = 0; i < s.length(); i++)
            {
                String myBuffer = buffer + s.charAt(i);
                String myString = new StringBuilder(s).deleteCharAt(i).toString();
                int palindromeLength = dfsFindLongestPalindrome(myString, myBuffer);
                longestPalindrome = Math.max(longestPalindrome, palindromeLength);
            }

            return longestPalindrome;
        }

        private boolean isPalindrome(String str)
        {
            if (str.isEmpty()) return false;

            int lngth = str.length();
            for (int i = 0; i < lngth / 2; i++)
            {
                if (str.charAt(i) != str.charAt(lngth - 1 - i)) return false;
            }

            return true;
        }
    }
}