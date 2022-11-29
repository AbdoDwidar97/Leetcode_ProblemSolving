package Strings;

import java.util.ArrayList;
import java.util.List;

public class CellsInRangeOnExcelSheet
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        List<String> res = solution.cellsInRange("U7:X9");
        res.forEach(System.out::println);
    }

    private static class Solution
    {
        public List<String> cellsInRange(String s)
        {
            List<String> result = new ArrayList<>();

            String[] myInput = s.split(":");

            int startRow = Integer.parseInt(myInput[0].charAt(1) + "");
            int endRow = Integer.parseInt(myInput[1].charAt(1) + "");
            int numOfRows = endRow - startRow + 1;
            int numberOfColumns = myInput[1].charAt(0) - myInput[0].charAt(0) + 1;

            int length = numberOfColumns * numOfRows;

            char currentChar = myInput[0].charAt(0);
            int currentNumber = startRow;

            for (int i = 0; i < length; i++)
            {
                if (currentNumber > endRow)
                {
                    currentNumber = startRow;
                    currentChar = (char) (currentChar + 1);
                }

                result.add(currentChar + "" + currentNumber);

                currentNumber++;
            }

            return result;
        }

    }
}
