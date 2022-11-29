import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        // char [] h5a = new char[]{'a', 'b', 'c', 'h'};
        // String res = longestCommonPrefix2(new String[] {"flower","flow","flight"});
        // String res = longestCommonPrefix2(new String[] {"dog","racecar","car"});
        String res = longestCommonPrefix2(new String[] {"ab","a"});
        System.out.println(res);
    }

    // Dumb way
    public static String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 1) return strs[0];

        int minLength = Arrays.stream(strs)
                .min(Comparator.comparing(String::length))
                .get().length();

        for (int idx = 0; idx < strs.length; idx++)
        {
            for (int wIdx = 0; wIdx < minLength; wIdx++)
            {
                final String prefix = strs[0].substring(0, wIdx + 1);
                long count = Arrays.stream(strs).filter(element -> element.startsWith(prefix)).count();

                if (count != strs.length) return prefix.substring(0, prefix.length() - 1);
                if (wIdx == minLength - 1) return prefix;
            }
        }

        return "";
    }

    // Smart way
    public static String longestCommonPrefix2(String[] strs)
    {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++)
        {
            while (!strs[i].startsWith(prefix))
            {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
