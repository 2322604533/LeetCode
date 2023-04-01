package Zeus.arithmetic;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combine {
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        if (k <= 0 || n < k) return res;

        // 从1开始
        Deque<Integer> path = new ArrayDeque<>();

        dfs(n, k, 1, path, res);

        return res;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return ;
        }

        // 遍历可能搜索的起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量添加一个数
            path.addLast(i);

            // 下一轮搜索
            dfs(n, k, i+1, path, res);

            // 深度优先遍历有回头的过程，因此递归之前做了什么，递归之后做了它的逆向操作
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        List<List<Integer>> lists = combine(4, 2);

        System.out.println("lists:"+lists);
    }
}
