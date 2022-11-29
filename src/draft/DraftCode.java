package draft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DraftCode
{
    public static void main(String[] args) {
        /*char chr = '0';
        char chr2 = '9';

        int n = chr;
        int n2 = chr2;

        System.out.println(n);
        System.out.println(n2);*/

        /*ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println(arr.indexOf(6));*/

        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 0);
        map1.put(2, 0);

        HashMap<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 1);
        map2.put(2, 0);

        map1.remove(map2);

    }
}
