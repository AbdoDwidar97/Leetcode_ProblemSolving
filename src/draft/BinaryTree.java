package draft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryTree
{
    public static void main(String[] args)
    {
        /*int x = 5;
        int y = 2;

        int res = x / y;
        // System.out.println(res);

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(3, 2, 4)));
        list.add(new ArrayList<>(Arrays.asList(5, 6)));*/

        // list.forEach(element -> element.forEach(System.out::println));

        /*int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) System.out.println(arr[i] + " h5a");*/

        /*String str = "codeleet";
        int[] arr = new int[]{4,5,6,7,0,2,1,3};

        int lnth = str.length();
        char[] nStr = new char[lnth];

        for (int i = 0; i < arr.length; i++)
        {
            nStr[arr[i]] = str.charAt(i);
        }*/

        // System.out.println(new String(nStr));

        // String h5a = "AF";
        /*int a7a = h5a.charAt(1) - h5a.charAt(0);
        System.out.println(a7a);*/

        /*String h5a = "RLRRLL-LRRRLL-";
        String h5a2 = "-RRRLL";
        String h5a3 = "-";
        String h5a4 = "RRRLLLRRL";

        System.out.println(h5a.split("-").length);
        System.out.println(h5a2.split("-").length);
        System.out.println(h5a3.split("-").length);
        System.out.println(h5a4.split("-").length);*/

        /*for (int i = 0; i < 100; i++)
        {
            if (i == 20) break;
            System.out.println(i);
        }*/

        String h4a = "(1)+((2))+(((3)))";

        // Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(h4a);

        while (matcher.find())
        {
            System.out.println(matcher.group(1));
        }

        // if (matcher.find()) System.out.println(matcher.group(1));

    }
}
