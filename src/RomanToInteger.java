import java.util.HashMap;
import java.util.Map;

public class RomanToInteger
{
    public static void main(String[] args)
    {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s)
    {
        int integerValue = 0;
        Map<Character, Integer> romanCodeBook = new HashMap<>();
        romanCodeBook.put('I', 1);
        romanCodeBook.put('V', 5);
        romanCodeBook.put('X', 10);
        romanCodeBook.put('L', 50);
        romanCodeBook.put('C', 100);
        romanCodeBook.put('D', 500);
        romanCodeBook.put('M', 1000);

        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            if (i > 0 && romanCodeBook.get(s.charAt(i)) > romanCodeBook.get(s.charAt(i - 1)))
            {
                int sum = romanCodeBook.get(s.charAt(i)) - romanCodeBook.get(s.charAt(i - 1));
                integerValue -= romanCodeBook.get(s.charAt(i - 1));
                integerValue += sum;

            }
            else integerValue += romanCodeBook.get(s.charAt(i));

        }

        return integerValue;
    }
}
