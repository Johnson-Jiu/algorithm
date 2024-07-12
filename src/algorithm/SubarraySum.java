package algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 和为 K 的子数组
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {

/*
        使用前缀和的方法可以解决这个问题，因为我们需要找到和为k的连续子数组的个数。
        通过计算前缀和，我们可以将问题转化为求解两个前缀和之差等于k的情况。

        假设数组的前缀和数组为prefixSum，其中prefixSum[i]表示从数组起始位置到第i个位置的元素之和。
        那么对于任意的两个下标i和j（i < j），如果prefixSum[j] - prefixSum[i] = k，
        即从第i个位置到第j个位置的元素之和等于k，那么说明从第i+1个位置到第j个位置的连续子数组的和为k。

        通过遍历数组，计算每个位置的前缀和，并使用一个哈希表来存储每个前缀和出现的次数。
        在遍历的过程中，我们检查是否存在prefixSum[j] - k的前缀和，如果存在，说明从某个位置到当前位置的连续子数组的和为k，
        我们将对应的次数累加到结果中。

        这样，通过遍历一次数组，我们可以统计出和为k的连续子数组的个数，并且时间复杂度为O(n)，其中n为数组的长度。
*/

        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}


//暴力
/*        Arrays.sort(nums);
                int res = 0;
                for (int i = 0; i < nums.length; i++) {
        int tempSum = 0;
        for (int j = i; j < nums.length; j++) {
        tempSum += nums[j];
        if(tempSum == k){
        res++;
        }
        }
        }
        return res;*/
