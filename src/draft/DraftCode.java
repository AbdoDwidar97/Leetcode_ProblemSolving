package draft;

import java.util.*;

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

        /*HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 0);
        map1.put(2, 0);

        HashMap<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 1);
        map2.put(2, 0);

        map1.remove(map2);*/

        // System.out.println(7 % 5);

        /*PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(12);
        q.add(200);
        q.add(0);
        q.add(-20);
        q.add(14);
        q.add(1001);

        System.out.println(q.poll());*/

        // int[][] arr = new int[][]{{1, 1}, {2, 1, 1, 1}, {7, 12, 6}, {4}};

        // System.out.println(29 % 10);

        // System.out.println(61 % 60);

        /// Copy array by reference
        /*int[] h5a1 = new int[]{1, 2, 3};
        int[] h5a2 = h5a1.clone();

        h5a2[0] = 60;

        Arrays.stream(h5a1).forEach(System.out::println);
        System.out.println("----------------");
        Arrays.stream(h5a2).forEach(System.out::println);*/

        // System.out.println(Integer.toBinaryString((int) Math.pow(10, 5)).length());
        int var = 5;
        while (var > 0)
        {
            System.out.println(var & 1);
            var = var >> 1;
        }

    }
}
