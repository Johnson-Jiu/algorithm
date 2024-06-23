package algorithm;

public class MoveZeroes {

    /**
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */

    public void moveZeroes(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if(nums[right] == 0){
                right++;
                continue;
            }
            nums[left] = nums[right];
            left++;
            right++;
        }
        while (left < nums.length){
            nums[left] = 0;
            left++;
        }
    }
}
