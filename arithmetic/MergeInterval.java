package Zeus.arithmetic;

import java.util.Arrays;

public class MergeInterval {

    /**
     * 合并区间：双指针
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {

        // 按照区间起始位置排序
        Arrays.sort(intervals,(v1, v2) -> v1[0]-v2[0]);

        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int index = -1;

        for (int[] interval : intervals) {
            // 如果数组是空的，或者当前位置的起始位置大于结果数组最后区间的终止位置
            // 则不合并，直接将当前区间加入结果数组
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }

        return Arrays.copyOf(res,index+1);
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        int[][] answer = merge(nums);

        for (int[] interval : answer) {
           for (int i = 0; i < interval.length; i++) {
               System.out.print(interval[i]+",");
           }
            System.out.println();
        }
    }
}
