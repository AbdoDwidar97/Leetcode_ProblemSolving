package TreeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDepthOfN_aryTree
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        Node root = new Node(1);
        root.children = new ArrayList<>(Arrays.asList(new Node(3), new Node(2), new Node(4)));
        root.children.get(0).children = new ArrayList<>(Arrays.asList(new Node(5), new Node(6)));

        int res = solution.maxDepth(root);
        System.out.println(res);
    }

    private static class Solution
    {
        public int maxDepth(Node root)
        {
            return getMaxDepth(root, 1);
        }

        private int getMaxDepth(Node root, int level)
        {
            int maxVal = 0;
            if (root == null) return 0;
            if (root.children == null || root.children.isEmpty()) return level;

            for (Node child : root.children)
            {
                int res = getMaxDepth(child, level + 1);
                if (res >= maxVal) maxVal = res;
            }

            return maxVal;
        }
    }

    private static class Node
    {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
