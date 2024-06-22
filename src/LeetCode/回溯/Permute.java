package LeetCode.回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[nums.length];
        back(res,nums,used,new ArrayList<Integer>());
        return res;
     }

    private void back(List<List<Integer>> res, int[] nums, int[] used, ArrayList<Integer> list) {
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
            back(res, nums, used, list);
            used[i] = 0;
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test(){
        int[] ints = {1,2,3};
        System.out.println(permute(ints));;
    }


}
