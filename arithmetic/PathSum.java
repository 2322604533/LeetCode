package zeus.arithmetic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSum {
    /**
     * 路径求和
     * 采用先序遍历的方式，先使用sum减去当前结点的值，然后递归左子树和右子树。
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> resList = new ArrayList<>();

        if (root == null) return resList;

        // java文档中Stack类建议使用Deque代替Stack(这里只是用Stack的接口)
        Deque<Integer> path = new ArrayDeque<>();

        dfs(root, targetSum, path, resList);

        return resList;
    }

    private void dfs(TreeNode node, int targetSum, Deque<Integer> path, List<List<Integer>> resList) {
        // 递归终止条件1
        if (node == null) return;

        // 递归终止条件2(该节点是叶子结点，并且叶子结点的值等于target)
        if (node.val == targetSum && node.left == null && node.right == null) {
            path.addLast(node.val); // 将一条路径中的元素入栈
            resList.add(new ArrayList<>(path)); // 将该路径加入的到结果集中
            path.removeLast();  // 将一条连路径的元素出栈,清空这条路径
            return;
        }
        path.addLast(node.val);
        dfs(node.left, targetSum - node.val, path, resList);
        dfs(node.right, targetSum - node.val, path, resList);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSum p = new PathSum();

        List<List<Integer>> lists = p.pathSum(root, 22);

        for (List<Integer> list : lists) {
            System.out.println("list:"+list);
        }

    }
}
