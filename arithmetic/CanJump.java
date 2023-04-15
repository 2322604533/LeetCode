package zeus.arithmetic;

public class CanJump {

    public static boolean canJump(int nums[]) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxIndex < i) return false;

            // Storing max index value we can reach from current index.
            maxIndex = Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }

    /**
     * Methods1
     * @param nums
     * @return
     */
    /**public static boolean canJump(int[] nums) {

        if (nums.length == 1) return true;

        int dp[] = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 1) return false;

            dp[i] = Math.max(dp[i-1]-1, nums[i]);

            if (dp[i] < 0) return false;
        }
        return true;
    }*/

    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};

        boolean res = canJump(nums);

        System.out.println("res:"+res);
    }
}
