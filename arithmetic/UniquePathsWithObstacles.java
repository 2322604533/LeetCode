package Zeus.arithmetic;

public class UniquePathsWithObstacles {

    /**
     * 从左上角到右下角
     * dp : f(m,n) = f(m-1,n) + f(m,n-1)
     * dp[i][j] 为走到格子(i,j)的路有多少条
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        /*
         * 普通版本
        // System.out.println("row:"+row+",col:"+col);

        int[][] dp = new int[row][col];

        // 若在起点或者终点遇到障碍,直接返回0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][col-1] == 1) return 0;

        // 一直向右走
        for (int i = 0; (i < row && obstacleGrid[i][0] == 0); i++) dp[i][0] = 1;
        // 一直向下走
        for (int j = 0; (j < col && obstacleGrid[0][j] == 0); j++) dp[0][j] = 1;


        // System.out.println(obstacleGrid[2][2]);
        // 遇到(i,j)有障碍 => dp[i][j] = 0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i][j-1] + dp [i-1][j] : 0;
            }
        }
        return dp[row-1][col-1];
         */

        // 优化版本
        int[] dp = new int[col];

        // 一直往右走
        for (int j = 0; (j < col && obstacleGrid[0][j] == 0); j++) dp[j] = 1;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if ( j!= 0){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[col-1];
    }
    public static void main(String[] args) {
        int[][] nums = {{0,0,0}, {0,1,0}, {0,0,0}};

        int res = uniquePathsWithObstacles(nums);

        System.out.println("res:"+res);
    }
}
