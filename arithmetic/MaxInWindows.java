package Zeus.arithmetic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInWindows {

    public static int[] maxInWindows(int nums[], int k) {
        int len = nums.length;

        if (nums == null || len < 2) return nums;

        // 双向队列,保存当前窗口最大值的数组位置,保证队列数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();

        int[] res = new int[len-k+1];

        for (int i = 0; i < len; i++) {
            // 当前队尾的元素对应的数组元素和接下来的数组元素比较，如果前者小于后者，那么将队尾元素出队
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();

            queue.addLast(i);

            // 判断当前队列中队首的值是否有效
            if (queue.peekLast() <= i-k) queue.pollLast();

            // 当窗口长度为k时 保存当前窗口中最大值
            if (i+1 >= k) res[i+1-k] = nums[queue.peek()];
        }

        return res;
    }

    public static void main(String args[]) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = maxInWindows(nums,3);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+",");
        }


        /*
        Deque<String> queue = new ArrayDeque<>();
        queue.add("Java");
        queue.add("C++");
        queue.add("C");
        queue.add("Go");
        queue.add("PHP");
        queue.add("C#");
        queue.add("Python");
        System.out.println("queue:"+queue);
        System.out.println("peekLast:"+queue.peekLast());
        System.out.println("queue:"+queue);
        // 队尾元素出队
        System.out.println("pollLast:"+queue.pollLast());
        System.out.println("queue:"+queue);*/
    }
}