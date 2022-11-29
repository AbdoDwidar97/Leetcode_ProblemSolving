import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PalindromeNumber
{
    public static void main (String[] args)
    {
        System.out.println(isPalindrome3(121));
    }

    // Dumb way
    public static boolean isPalindrome(int x)
    {
        String xStr = String.valueOf(x);

        String left = xStr.substring(0, xStr.length() / 2);
        String right;

        if (xStr.length() % 2 == 0) right = xStr.substring(xStr.length() / 2);
        else right = xStr.substring((xStr.length() / 2) + 1);

        String revRight = "";
        for (int i = right.length() - 1; i >= 0; i--)
        {
            revRight += right.charAt(i);
        }

        return left.equals(revRight);
    }

    // Smart way
    public static boolean isPalindrome2(int x)
    {
        if (x < 0) return false;

        ArrayList<Integer> number = new ArrayList<>();

        while (x >= 1)
        {
            number.add(x % 10);
            x /= 10;
        }

        for (int i = 0; i < number.size(); i++)
        {
            if (!Objects.equals(number.get(i), number.get(number.size() - 1 - i))) return false;
        }

        return true;
    }

    // another smart way
    public static boolean isPalindrome3(int x)
    {
        if (x < 0) return false;

        Map<Integer, Integer> number = new HashMap<>();

        int itr = 0;
        while (x >= 1)
        {
            number.put(itr++, x % 10);
            x /= 10;
        }

        for (int i = 0; i < itr; i++)
        {
            if (!Objects.equals(number.get(i), number.get(itr - 1 - i))) return false;
        }

        return true;
    }

}
