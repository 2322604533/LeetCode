package zeus.arithmetic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    /**
     * 二叉树的层次遍历
     * 使用队列的进行层次遍历
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) queue.add(root);  // 根结点入队

        // System.out.println("queue.size:"+queue.size());

        while (!queue.isEmpty()) {
            int size = queue.size();   // 当前层次的队列大小

            // System.out.println("size:"+size);

            List<Integer> level = new ArrayList<>();    // 记录当前层次的数据

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();   // 出队

                level.add(node.val);

                if (node.left != null) queue.add(node.left);  // 左孩子入队

                if (node.right != null) queue.add(node.right);  // 右孩子入队
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(7);

        root.right.right.left = new TreeNode(8);

        root.right.right.right = new TreeNode(9);

        List<List<Integer>> lists = levelOrder(root);

        for (List<Integer> list : lists) {
            System.out.println("list:"+list);
        }
    }
}







