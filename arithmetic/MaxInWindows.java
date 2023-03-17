package Zeus.arithmetic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxInWindows {

    public static int[] maxInWindows(int nums[], int k) {
        int len = nums.length;

        if (nums == null || len < 2) return nums;

        // 双向队列,保存当前窗口最大值的数组位置,保证队列数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < len; i++) {
            // 保证从大到小,如果前面数小则需要依次弹出，直至满足条件要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            // 添加当前值对应的数组下标
            queue.addLast(i);

            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= (i - k)) queue.poll();

            // 当前窗口长度为k时,保存当前窗口中最大值
            if (i+1 >= k) res[i+1-k] = nums[queue.peek()];
        }

        return res;
    }

    public static void main(String args[]) {

    }
}
