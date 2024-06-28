package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]
 */

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        if(nums.length == 1){
            res.add(Collections.singletonList(nums[0]));
            return res;
        }
        int[] used = new int[nums.length];
        back(nums, new ArrayList<Integer>(), res, used);
        return res;
    }

    private void back(int[] nums, ArrayList<Integer> list, ArrayList<List<Integer>> res, int[] used) {
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] == 1){
                continue;
            }
            used[i] = 1;
            list.add(nums[i]);
            back(nums, list, res, used);
            used[i] = 0;
            list.remove(list.size() - 1);
        }
    }

}
