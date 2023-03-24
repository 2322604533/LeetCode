package Zeus.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        // 一个n个元素的集合包含2^n个子集合
        // nums = {1,2,3}
        // [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]];
        // String a = Integer.toBinaryString(i);
        // String b = Integer.toBinaryString(j);
        // System.out.println(i+"向右移"+j+"位");
        // System.out.println("a : "+a+", b : "+b+"; a >> b : "+(i >> j));
        // System.out.println("---------------------------");
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 将二进制数i从低位到高位逐个取二进制位,并且判断是否位1
                // 如 101 & 001 => 001; 100 & 001 = 0
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);

        System.out.println("lists:"+lists);
    }
}
