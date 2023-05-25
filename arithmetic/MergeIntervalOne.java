package zeus.arithmetic;

import java.util.Arrays;

public class MergeIntervalOne {

    /**
     * 合并区间：双指针
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {

        // 按照每个区间的左端点从大到小排序
        Arrays.sort(intervals,(v1, v2) -> v1[0]-v2[0]);

        // 结果区间段的个数不超过原始的区间段个数
        int[][] res = new int[intervals.length][2];

        int index = -1;

        // for (int i = 0; i < k; i++) {
        //    interval[i][0] interval[i][1]
        // }
        for (int[] interval : intervals) {
            // interval[i][0] > res[index][1] 当前遍历到的位置的左端点 > 结果集的右边端点说明不重叠
            // 则就继续到下一个区间段，将前面的不重叠的区间段挂载到结果集中
            if (index == -1 || interval[0] > res[index][1]) {
                index = index + 1; res[index] = interval;
            } else {
                // 重叠 interval[i][0] <= res[index][1]
                // 当前位置的左端点 <= 结果集合中的右边端点，说明重合
                // 然后结果集合中的右边端点和当前遍历到区间段的右端点比较，
                // 哪个大就放在结果集合中的右端点 res:{1,3}; interval:{2,6} => res:{1,6}
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }


        // nums1{1 2 3 4 5};
        // Arrays.copyOf(nums1, 10);
        // num2{1 2 3 4 5 0 0 0 0 0};
        return Arrays.copyOf(res,index + 1);
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
