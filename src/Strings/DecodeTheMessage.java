package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class DecodeTheMessage
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

    private static class Solution
    {
        public String decodeMessage(String key, String message)
        {
            int aAscii = 97;
            HashMap<Character, Character> table = new HashMap<>();

            key = key.replace(" ", "");

            for (int i = 0; i < key.length(); i++)
            {
                if (aAscii > 122) break;
                if (!table.containsKey(key.charAt(i)))
                {
                    table.put(key.charAt(i), (char) (aAscii));
                    aAscii++;
                }
            }

            String decodedMessage = "";
            for (int i = 0; i < message.length(); i++)
            {
                if (message.charAt(i) == ' ') decodedMessage += ' ';
                else decodedMessage += table.get(message.charAt(i));
            }

            return decodedMessage;
        }
    }
}
