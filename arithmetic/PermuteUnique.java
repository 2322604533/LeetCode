package Zeus.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {

    // 存放结果
    private static List<List<Integer>> res = new ArrayList<>();

    // 暂时存放一个分支的路径
    private static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] used = new boolean[nums.length];

        Arrays.fill(used, false);

        Arrays.sort(nums);

        dfs(nums,used);

        return res;
    }

    private static void dfs(int[] nums, boolean[] used) {
        // 说明该路径已经到达了叶结点，该路径长度为数组的长度
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            // used[i-1] == true; => 说明同一分支的num[i-1]使用过
            // used[i-1] == false; => 说明该树同一层nums[i-1]使用过
            // 如果同一树层nums[i-1]使用过，则直接跳过
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false) continue;

            // 开始访问used[i] == false 的结点
            if (used[i] == false) {
                used[i] = true; //开始访问将该对应的结点置为true

                path.add(nums[i]);

                dfs(nums, used);

                path.remove(path.size()-1); //回溯

                used[i] = false;
            }

         }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,};
        List<List<Integer>> lists = permuteUnique(nums);

        for (List<Integer> list : lists) {
            System.out.print(list+",");
        }
    }
}
