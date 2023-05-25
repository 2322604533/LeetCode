package zeus.arithmetic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeIntervalTwo {

    private static int k = 0;

    /**
     * 插入区间
     * @param intervals 原区间
     * @param newInterval 添加的区间
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        // case1: [[]] + [2,5] => [[2,5]]

        // case2: [[1,5]] + [2,3] => [[1,5]]

        // case3: [[1,5], [8,9]] + [6,7] => [[1,5], [6,7], [8,9]]

        int len = intervals.length;

        int[][] res = new int[len+ 1][2];

        int i = 0, index = 0;   // 当前方法的全局变量

        // 当前遍历的是将新区间左边且相离的区间挂载到结果集中
        // case3: intervals[[1,5], [8,9]] + newInterval[6,7] => res[[1,5], [6,7], [8,9]]
        while (i < len && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }

        // 当前遍历的是判断区间是否重叠 ? 合并 : 继续
        // 如果不重叠，当i = intervals.length 时结束，否则重叠就合并，然后就结束
        // case4: [[1,3], [4,7], [8,10], [12,14]] + [2,11] => [[1,11],[12,14]]
        //           [2,    11]
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // res[i] = newInterval; i = i + 1;
        res[index++] = newInterval;

        // 最后原来区间右边且相离的区间加入到结果集中
        while (i < len) {
            res[index++] = intervals[i++];
        }

        k = index;

        return Arrays.copyOf(res, index);
    }

    public static void main(String[] args) {
        int[][] num = {{1,3}, {4,7}, {8,10}, {12,14}, {15,17}, {19,21}};

        int[] target = {2,11};

        int[][] res = insert(num, target);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("res => " + res[i][j]);
            }
        }

    }
}
