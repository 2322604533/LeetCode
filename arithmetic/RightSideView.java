package zeus.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    /**
     * 只要遍历右子树 => BFS
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);  // 入队

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();   // 取对头并且删除对头

                if (node.left != null) queue.offer(node.left);

                if (node.right != null) queue.offer(node.right);

                if (i == size-1) res.add(node.val);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(); root.left.val = 2;
        root.left.right = new TreeNode(); root.left.right.val = 5;

        root.right = new TreeNode(); root.right.val = 3;
        root.right.right = new TreeNode(); root.right.right.val = 4;

        List<Integer> ans = rightSideView(root);
        for (int value : ans) {
            System.out.print(value+",");
        }
    }
}
