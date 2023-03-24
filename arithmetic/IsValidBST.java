package Zeus.arithmetic;

public class IsValidBST {
    private long preNodeVal = Long.MIN_VALUE;
    /**
     * 判断该二叉树是否为二叉排序树
     * 利用中序遍历
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // 递归访问左子树
        if (!isValidBST(root.left)) return false;

        // 访问当前结点,如果当前结点小于等于中序遍历的前一个结点,说明不满足BST,返回false,否则继续
        if (root.val <= preNodeVal) return false;

        preNodeVal = root.val;

        // 访问右子树
        return isValidBST(root.right);
    }

    public static void main(String[] args) {

        IsValidBST obj = new IsValidBST();

        TreeNode root = new TreeNode();

        root.val = 2;

        root.left = new TreeNode();
        root.left.val = 1;

        root.right = new TreeNode();
        root.right.val = 3;

        boolean res = obj.isValidBST(root);
        System.out.println("res:"+res);
    }
}
