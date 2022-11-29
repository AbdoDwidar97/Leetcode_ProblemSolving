package TreeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_aryTreeLevelOrderTraversal
{
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.children = new ArrayList<>(Arrays.asList(new Node(3), new Node(2), new Node(4)));
        root.children.get(0).children = new ArrayList<>(Arrays.asList(new Node(5), new Node(6)));

        Solution solution = new Solution();

        List<List<Integer>> res = solution.levelOrder(root);
        // res.forEach(element -> element.forEach(System.out::println));
        for (List<Integer> itr : res)
        {
            for (int num : itr)
            {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }

    private static class Solution
    {
        private List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> levelOrder(Node root)
        {
            checkTree(root, 1);
            return list;
        }

        private void checkTree(Node root, int level)
        {
            if (root == null) return;

            if (list.size() < level)
            {
                list.add(new ArrayList<>(Arrays.asList(root.val)));
            }else list.get(level - 1).add(root.val);

            if (root.children == null) return;

            for (Node child : root.children)
            {
                checkTree(child, level + 1);
            }
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
