package LeetCode.dongtaiguihua;

public class MaxProfit {
    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp= new int[len][2];
        dp[0][0] = 0; //未持股
        dp[0][1] = -prices[0];//持有股票
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[0][0] - prices[i]);
        }
        return dp[len-1][0];
    }

}
