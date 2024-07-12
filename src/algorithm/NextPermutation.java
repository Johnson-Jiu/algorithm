package algorithm;

import java.util.Arrays;

/**
 * 下一个排列
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 从后往前，找到前一位比当前位置小的(i-1 < i)
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            //12385764 --> 12386457
            // 人话： (nums[下标4] = 5) < (nums[下标5] = 7)
            if (nums[i] > nums[i - 1]) {

                // 将 [i] -> [length] 排序,这里是 7 6 4
                Arrays.sort(nums, i, len);
                // 排序完成之后的结果
                // 1 2 3 8 5     4 6 7

                //只遍历 4 6 7
                //i->end排序后，直接升序里找一个k，nb
                for (int j = i; j < len; j++) {

                    // 从左往右，在 4 6 7 中找到第一个 > nums[下标4] = 5
                    // 注意是 nums[i - 1] 是 i-1 ，不是 j !!!
                    if (nums[j] > nums[i - 1]) {

                        //交换位置，然后return
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
            //如果走一遍空循环，看下一行注释
        }
        // 上面循环完之后，程序还在运行说明 此排列已经最大
        // 做一个升序排列就完事
        Arrays.sort(nums);
    }
}
