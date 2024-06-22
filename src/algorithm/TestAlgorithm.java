package algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Mr Wrong
 */

/**
 输入：[7,1,5,3,6,4]
 输出：5
 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
 */
public class TestAlgorithm {
    @Test
    public void test(){
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1],nums[i-1] + dp[i-2]);
        }
        return dp[nums.length];
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int [len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            // 这里dp[i - 1][1] + prices[i]为什么能保证只卖了一次，因为下面一行代码买的时候已经保证了只买一次，所以这里自然就保证了只卖一次，不管是只允许交易一次还是允许交易多次，这行代码都不用变，因为只要保证只买一次（保证了只卖一次）或者买多次（保证了可以卖多次）即可。
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //  - prices[i]这里可以理解为dp[0][0] - prices[i]，这里为什么是dp[0][0] - prices[i]，因为只有这样才能保证只买一次，所以需要用一开始初始化的未持股的现金dp[0][0]减去当天的股价
            dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] - prices[i]);
            // 如果题目允许交易多次，就说明可以从直接从昨天的未持股状态变为今天的持股状态，因为昨天未持股状态可以代表之前买过又卖过后的状态，也就是之前交易过多次后的状态。也就是下面的代码。
            //dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i/2] + 1;
            }
        }
        return dp;
    }
}
