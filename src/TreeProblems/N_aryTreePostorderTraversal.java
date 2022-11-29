package TreeProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_aryTreePostorderTraversal
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        Node root = new Node(1);
        root.children = new ArrayList<>(Arrays.asList(new Node(3), new Node(2), new Node(4)));
        root.children.get(0).children = new ArrayList<>(Arrays.asList(new Node(5), new Node(6)));

        List<Integer> res = solution.postorder(root);
        res.forEach(System.out::println);
    }

    private static class Solution
    {
        private List<Integer> list = new ArrayList<>();
        public List<Integer> postorder(Node root)
        {
            postOrderDfs(root);
            if (root != null) list.add(root.val);
            return list;
        }

        private void postOrderDfs(Node root)
        {
            if (root == null) return;
            if (root.children == null) return;

            for (Node child : root.children)
            {
                postOrderDfs(child);
                list.add(child.val);
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
