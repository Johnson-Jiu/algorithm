package algorithm;

/**
 * 数组中的第K个最大元素
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int target = quickSearch(nums, 0, nums.length - 1, k);
        return target == -1? nums[k-1] : target;

    }

    private int quickSearch(int[] nums, int left, int right, int target){
        int i = left;
        int j = right;

        if(left > right){
            return -1;
        }
        int temp = nums[left];
        while (left < right){
            // 找到第一个比temp大的下标
            while (nums[right] <= temp && left < right){
                right--;
            }
            nums[left] = nums[right];

            // 找到第一个比temp小的下标
            while (nums[left] >= temp && left < right){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        if(left == target-1){
            return temp;
        }
        quickSearch(nums, i, left-1, target);
        quickSearch(nums, left+1, j, target);
        return -1;
    }
}
