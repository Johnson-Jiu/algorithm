package LeetCode.dongtaiguihua;

import org.junit.Test;

import java.util.*;

public class ThreeSum {
    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：[]
     */

    @Test
    public void test(){

    }

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        Set<List<Integer>> lists = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0)break;
            int left = i;
            int mid = i+1;
            int right = nums.length-1;
            while (mid < right){
                if(nums[left] + nums[right] + nums[mid] == 0){
                    lists.add(Arrays.asList(nums[left] ,nums[right] ,nums[mid] ));
                    mid++;
                }else if(-nums[left] > (nums[mid] + nums[right])){
                    mid++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<>(lists);
    }
}
