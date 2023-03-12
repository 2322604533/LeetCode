package Zeus.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) return res;

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);

        return res;
    }

    private static void dfs(int[] nums, int len, int depth, List<Integer> path,
                            boolean[] used, List<List<Integer>> res) {
        // 递归终止条件
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return ;
        }

        // 在非叶子节点处，产生不同的分支
        // =>在还未选择的元素中选择一个作为非叶节点
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth+1, path, used, res);

                // 回溯发生在从深层结点到浅层结点
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = permute(nums);
        System.out.println("lists=>"+lists);
    }
}
