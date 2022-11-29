package TreeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_aryTreePreorderTraversal
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Node root = new Node(1);
        root.children = new ArrayList<>(Arrays.asList(new Node(3), new Node(2), new Node(4)));
        root.children.get(0).children = new ArrayList<>(Arrays.asList(new Node(5), new Node(6)));

        List<Integer> res = solution.preorder(root);
        res.forEach(System.out::println);
    }

    private static class Solution
    {
        List<Integer> list = new ArrayList<>();

        public List<Integer> preorder(Node root)
        {
            preOrderTree(root);
            return list;
        }

        private void preOrderTree(Node root)
        {
            if (root == null) return;
            list.add(root.val);
            if (root.children == null) return;

            for (Node child : root.children)
            {
                preOrderTree(child);
            }
        }
    }

    private static class Node {
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
    };
}
