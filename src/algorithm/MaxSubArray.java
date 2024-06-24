package algorithm;

/**
 * 最大子数组和
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        int left = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left = Math.max(nums[i], left + nums[i]);
            max = Math.max(max, left);
        }
        return max;

    }
}
