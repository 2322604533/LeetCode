package Zeus.arithmetic;

import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) return res;

        // 排序好后才能剪枝
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,len,0,target,res,path);
        return res;
    }

    private void dfs(int[] candidates, int len, int begin, int target, List<List<Integer>> res, Deque<Integer> path) {
        // 递归终止条件
        if (target == 0 ) res.add(new ArrayList<>(path));

        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (target - candidates[i] < 0) break;

            // 小剪枝,含有重复的元素
            if (i > begin && candidates[i] == candidates[i-1]) continue;

            path.addLast(candidates[i]);

            dfs(candidates,len,i+1,target-candidates[i],res,path);

            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }
}
