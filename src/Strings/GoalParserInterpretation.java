package Strings;

import java.util.HashMap;

public class GoalParserInterpretation
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.interpret2("G()(al)"));
    }

    private static class Solution
    {
        public String interpret(String command)
        {
            HashMap<String, String> codeBook = new HashMap<>();
            codeBook.put("G", "G");
            codeBook.put("()", "o");
            codeBook.put("(al)", "al");

            String buffer = "";
            String newString = "";

            final int length = command.length();
            for (int i = 0; i < length; i++)
            {
                buffer += command.charAt(i);
                if (codeBook.containsKey(buffer))
                {
                    newString += codeBook.get(buffer);
                    buffer = "";
                }
            }

            return newString;
        }

        // -------------------- Smart Way ------------------------

        public String interpret2(String command)
        {
            command = command.replace("()", "o");
            command = command.replace("(al)", "al");

            return command;
        }
    }
}
