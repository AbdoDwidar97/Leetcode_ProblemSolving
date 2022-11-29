package draft;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchExample
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 2, 6, 7, 12, 16, 50, 100, 102, 200, 216, 300, 400, 804, 1001, 1002, 6000, 6664, 7009};

        long start1 = System.nanoTime();
        boolean res = searchNumber(arr, 216, 0, arr.length - 1);
        long end1 = System.nanoTime();

        long time1 = end1 - start1;

        System.out.println("Result 1: " + res + ", Time 1: " + time1);

        long start2 = System.nanoTime();
        boolean res2 = searchNumber2(arr, 7009);
        long end2 = System.nanoTime();

        long time2 = end2 - start2;

       System.out.println("Result 2: " + res2 + ", Time 2: " + time2);
    }

    private static boolean searchNumber(int[] arr, int val, int start, int end)
    {
        int mid = ((end - start) / 2) + start;

        if (end == start && arr[mid] != val) return false;
        else if (val == arr[mid] || val == arr[start] || val == arr[end]) return true;
        else if (val > arr[mid]) return searchNumber(arr, val, mid + 1, end);
        else if (val < arr[mid]) return searchNumber(arr, val, start, mid);

        return false;
    }

    private static boolean searchNumber2(int[] arr, int val)
    {
        for (int j : arr) {
            if (val == j) return true;
        }

        return false;
    }

}
