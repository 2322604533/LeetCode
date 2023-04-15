package zeus.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetWithDup {

    private static List<List<Integer>> res = new ArrayList<>();

    private static LinkedList<Integer> path = new LinkedList<>();

    private static boolean used[]; // used[]进行复用

    public static List<List<Integer>> subsetWithDup(int[] nums) {
        if (nums.length == 0) {
            res.add(path);

            return res;
        }

        Arrays.sort(nums);

        used = new boolean[nums.length];

        dfs(nums, 0);

        return res;
    }

    private static void dfs(int[] nums, int beginIndex) {
        res.add(new ArrayList<>(path));

        if (beginIndex >= nums.length) return ; // 跳出递归

        for (int i = beginIndex; i < nums.length; i++) {
            // 如果当前的元素与上一个元素相同,并且上个元素已经被使用过,则跳过该元素
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] != true) continue;

            path.add(nums[i]);

            used[i] = true;

            dfs(nums, i+1); // beginIndex >= nums.length时跳出递归

            path.removeLast();   // 回溯

            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,2,3,4};

        List<List<Integer>> lists = subsetWithDup(nums);

        for (List<Integer> list : lists) {
            System.out.println("list:"+list);
        }
    }
}






