package algorithm;

/**
 * 搜索插入位置
 * 示例 1:
 *
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int index = (left + right) / 2;
            if(target == nums[index]){
                return index;
            }
            if(target > nums[index]){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }
        return right+1;
    }
}
