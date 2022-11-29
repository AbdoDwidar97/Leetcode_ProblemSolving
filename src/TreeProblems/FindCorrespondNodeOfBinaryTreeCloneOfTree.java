package TreeProblems;

import com.sun.source.tree.Tree;

public class FindCorrespondNodeOfBinaryTreeCloneOfTree
{
    public static void main(String[] args)
    {
        Solution3 solution = new Solution3();

        TreeNode2 original = new TreeNode2(7);
        original.left = new TreeNode2(4);
        original.right = new TreeNode2(3);
        original.right.left = new TreeNode2(6);
        original.right.right = new TreeNode2(19);

        TreeNode2 cloned = new TreeNode2(7);
        cloned.left = new TreeNode2(4);
        cloned.right = new TreeNode2(3);
        cloned.right.left = new TreeNode2(6);
        cloned.right.right = new TreeNode2(19);

        TreeNode2 res = solution.getTargetCopy(original, cloned, original.right);

        System.out.println(res.val);
    }
}

class Solution3
{
    public final TreeNode2 getTargetCopy(final TreeNode2 original, final TreeNode2 cloned, final TreeNode2 target)
    {
        if (original == null) return null;
        if (original == target) return cloned;

        TreeNode2 left = getTargetCopy(original.left, cloned.left, target);
        TreeNode2 right = getTargetCopy(original.right, cloned.right, target);

        if (left != null) return left;
        else return right;
    }
}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int x) { val = x; }
}
