package zeus.arithmetic;

public class IsSymmetric {

    /**
     * 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // 递归终止条件是两个结点都为||一个结点为空||两个结点的值不相同
        if (left == null && right == null) return true;

        if (left == null || right == null) return false;

        if (left.val != right.val) return false;

        // 递归比较左右孩子结点的值
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
