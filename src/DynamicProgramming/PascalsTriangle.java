package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.generate(5);
        for (List<Integer> r : res)
        {
            r.forEach(System.out::println);
            System.out.println("-----");
        }
    }

    private static class Solution
    {
        public List<List<Integer>> generate(int numRows)
        {
            return generateTriangle(new ArrayList<>(), numRows, 1);
        }

        private List<List<Integer>> generateTriangle(List<List<Integer>> triangle, int numOfRows, int level)
        {
            if (level == numOfRows + 1) return triangle;

            List<Integer> myLst = new ArrayList<>();

            for (int i = 0; i < level; i++)
            {
                if (i == 0 || i == level - 1) myLst.add(1);
                else
                {
                    int nm1 = triangle.get(level - 2).get(i - 1);
                    int nm2 = triangle.get(level - 2).get(i);
                    myLst.add(nm1 + nm2);
                }
            }

            triangle.add(myLst);

            return generateTriangle(triangle, numOfRows, level + 1);
        }
    }
}
