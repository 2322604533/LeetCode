package zeus.arithmetic;

import java.util.PriorityQueue;

public class MaxSlidingWindow {

    /**
     * 对于当前的队列而言，可以使用O(K)的时间遍历其中的每一个元素
     * 在k个元素当中找到最大值，因此结果的数组中有(n-k+1)，算法时间复杂度为O((n-k+1)k)
     * 但是会超时，因此可以想到两个相邻的窗口只差了一个元素，他们共用这(k-1)个元素，只有一个元素是变化的
     * 因此可以联想到结点只有 k 个的大根堆 ，也叫作[优先队列]，每一次移动都是对大根堆的添加和移除操作
     * 当最大值在滑动窗口的左边时，如 1，[3，-1，-3]，5，3，6，7 => 1，3，[-1，-3，5]，3，6，7
     * 将 3 移除堆中，然后调整堆的结构，保证这是大根堆
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[1] - a[1]));

        int[] res = new int[nums.length - k + 1];

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            maxHeap.add(new int[]{i, nums[i]});

            if (i >= k - 1) {

                while (maxHeap.peek()[0] <= i - k) maxHeap.poll();

                res[index++] = maxHeap.peek()[1];
            }
        }
        return res;
    }
}
