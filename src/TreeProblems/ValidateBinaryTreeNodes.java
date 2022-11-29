package TreeProblems;

import java.util.HashMap;
import java.util.HashSet;

public class ValidateBinaryTreeNodes
{
    public static void main(String[] args)
    {
        /*int[] leftChild = new int[]{1,-1,3,-1};
        int[] rightChild = new int[]{2,-1,-1,-1};*/

        /*int[] leftChild = new int[]{3, -1, 1, -1};
        int[] rightChild = new int[]{-1, -1, 0, -1};*/

        /*int[] leftChild = new int[]{1, 0, 3, -1};
        int[] rightChild = new int[]{-1, -1, -1, -1};*/

        int[] leftChild = new int[]{0, -1, 3, 1, 3};
        int[] rightChild = new int[]{4, 3, 0, 1, -1};

        Solution solution = new Solution();

        boolean res = solution.validateBinaryTreeNodes(leftChild.length, leftChild, rightChild);
        System.out.println(res);
    }

    private static class Solution
    {
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
        {
            int[] visitedNodes = new int[n];

            for (int node = 0; node < n; node++)
            {
                boolean isNodeCircle = isCircle(node, new int[n], leftChild, rightChild);

                if (isNodeCircle) return false;

                int left = leftChild[node];
                int right = rightChild[node];

                if (left != -1)
                {
                    visitedNodes[left] += 1;
                    if (visitedNodes[left] > 1) return false;
                }

                if (right != -1)
                {
                    visitedNodes[right] += 1;
                    if (visitedNodes[right] > 1) return false;
                }
            }

            int numOfRoots = 0;
            for (int i = 0; i < n; i++)
            {
                if (visitedNodes[i] == 0) numOfRoots++;
            }

            return numOfRoots == 1;
        }

        private boolean isCircle(int node, int[] visitedNodes, int[] left, int[] right)
        {
            if (node == -1) return false;
            visitedNodes[node]++;

            if (visitedNodes[node] > 1) return true;

            boolean lft = isCircle(left[node], visitedNodes, left, right);
            boolean rgt = isCircle(right[node], visitedNodes, left, right);

            return lft || rgt;
        }

        /// ------------------Smart Way (Wrong Answer)-------------------

        public boolean validateBinaryTreeNodes2(int n, int[] leftChild, int[] rightChild)
        {
            HashSet<Integer> visitedNodes = new HashSet<>();

            for (int i = 0; i < n; i++)
            {
                int left = leftChild[i];
                int right = rightChild[i];

                if (left != -1)
                {
                    if (visitedNodes.contains(left)) return false;
                    visitedNodes.add(left);
                }

                if (right != -1)
                {
                    if (visitedNodes.contains(right)) return false;
                    visitedNodes.add(right);
                }
            }

            return visitedNodes.size() == n - 1;
        }

    }
}
