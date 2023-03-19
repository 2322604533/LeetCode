package Zeus.arithmetic;

public class MaxSubArray {
    /**
     * 动态规划
     * 找出最大连续的子数组并且求最大子数组的和
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示以nums[i]结尾的连续子数组的最大和
        int[] dp = new int[len];

        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i-1] > 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 找出dp[]中的最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
         int nums[] = {-2,1,-3,4,-1,2,1,-5,4};

         int res = maxSubArray(nums);

        System.out.println("res:"+res);

    }
}





