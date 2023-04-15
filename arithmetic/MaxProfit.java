package Zeus.arithmetic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxProfit {
    private int res = 0;

    public int maxProfitWay1(int[] price) {
        int len = price.length;

        if (len < 2) return 0;

        // int[] price, int index, int len, int status, int profit
        dfs(price, 0, len, 0, res);

        return res;
    }

    /**
     *
     * @param price 股价数组
     * @param index 当前是第几天，从0开始
     * @param len
     * @param status 0表示不持有股票，1表示持有股票
     * @param profit 当前收益
     */
    private void dfs(int[] price, int index, int len, int status, int profit) {
        if (index == len) {
            this.res = Math.max(this.res, profit);
            return ;
        }
        dfs(price, index+1, len, status, profit);

        if (status == 0) {
            dfs(price, index+1, len, 1, profit-price[index]);   // 买入
        } else {
            dfs(price, index+1, len, 0,profit+price[index]);    // 卖出
        }
    }

    /**
     * 贪心算法
     * @param price
     * @return
     */
    public int maxProfitWay2(int price[]) {
        int len = price.length;

        if (len < 2) return 0;

        int res = 0;

        for (int i = 1; i < len; i++) {
            int difference = price[i] - price[i-1];
            if (difference > 0) {
                res += difference;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        MaxProfit m = new MaxProfit();
        int res1 = m.maxProfitWay1(new int[]{7, 1, 5, 3, 6, 4});
        int res2 = m.maxProfitWay2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("res1:"+res1);
        System.out.println("res2:"+res2);
    }
}
