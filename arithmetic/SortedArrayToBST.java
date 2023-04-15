package zeus.arithmetic;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int low, int high) {
        if (low > high) return null;

        // 找到中间的结点
        int mid = low + (high - low) / 2;

        TreeNode root  = new TreeNode(nums[mid]);

        // 递归构建root的左子树与右子树
        root.left = dfs(nums, low, mid - 1);
        root.right = dfs(nums, mid + 1, high);

        return root;
    }
}
