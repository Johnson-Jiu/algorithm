package LeetCode.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int[] used = new int[nums.length];
        back(res,nums,used,new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void back(Set<List<Integer>> res, int[] nums, int[] used, ArrayList<Integer> list) {
        if(list.size() != 0 && !res.contains(new ArrayList<>(list))){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i] == 1){
                continue;
            }
            used[i] = 1;
            list.add(nums[i]);
            back(res, nums, used, list);
            used[i] = 0;
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test(){
        int[] ints = {1,2,3};
        System.out.println(subsets(ints));
    }
}
