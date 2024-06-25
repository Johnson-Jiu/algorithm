package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class SearchRange {
    @Test
    public void test(){
        int[] nums = {1,4};
        System.out.println(Arrays.toString(searchRange(nums, 4)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target);
        int right = search(nums, target+1);
        if(left == nums.length || nums[left] != target){
            return new int[]{-1,-1};
        }
        return new int[]{left, right - 1};
    }
    //找>=target的第一个
    public int search(int[] nums,int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = (right + left)/2;
            if(target <= nums[mid]){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        return left;
    }

}
