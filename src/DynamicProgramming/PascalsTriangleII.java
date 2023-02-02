package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        List<Integer> res = solution.getRow(3);
        res.forEach(System.out::println);
    }

    private static class Solution
    {
        public List<Integer> getRow(int rowIndex)
        {
            return getRowForIndex(new ArrayList<>(), rowIndex, 0);
        }

        private List<Integer> getRowForIndex(List<Integer> lst, int rowIndex, int level)
        {
            if (level == rowIndex + 1) return lst;

            List<Integer> myLst = new ArrayList<>();

            if (level == 0) myLst.add(1);
            else
            {
                for (int i = 0; i <= level; i++)
                {
                    if (i == 0 || i == level) myLst.add(1);
                    else myLst.add(lst.get(i - 1) + lst.get(i));
                }
            }

            return getRowForIndex(myLst, rowIndex, level + 1);
        }
    }
}
