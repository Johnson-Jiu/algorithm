package algorithm;

/**
 * 跳跃游戏
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * [5,9,3,2,1,0,2,3,3,1,0,0]
 */

public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;

        /*if(nums.length == 0){
            return false;
        }
        if(nums.length == 1 && nums[0] == 0){
            return true;
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i+1] = nums[i] + i + 1;
            if(dp[i+1] >= nums.length){
                return true;
            }
            if(nums[i] == 0) {
                if(i != 0 && findTarget(i, nums)){
                    continue;
                }
                if(i != 0 && nums[i-1] >=2){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    private boolean findTarget(int i, int[] nums){
        int target = 2;
        while (i > 0){
            if(nums[--i] >= target++){
                return true;
            }
        }
        return false;*/
    }
}
