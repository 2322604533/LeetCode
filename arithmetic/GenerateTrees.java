package zeus.arithmetic;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定值为n,要求生成不同的二叉排序树
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行结点
        for (int i = start; i <= end; i++) {
            // 获得可能的所有左子树的集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得可能的所有右子树的集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树中选一棵作左子树，从右子树中选一棵作右子树;
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode curTree = new TreeNode();
                    curTree.left = leftTree;
                    curTree.right = rightTree;
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        GenerateTrees obj = new GenerateTrees();

        List<TreeNode> trees = obj.generateTrees(5);

        for (TreeNode node : trees) {
            System.out.println(node+",");
        }
    }
}
