package algorithm;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        //最低成本
        int lowCost = Integer.MAX_VALUE;
        //最大利润
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            lowCost = Math.min(lowCost, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - lowCost);
        }
        return maxProfit;

    }
}
