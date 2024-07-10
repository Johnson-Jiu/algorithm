package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        int start = 0;
        ArrayList<List<Integer>> res = new ArrayList<>();
        back(candidates, target, start, res, temp);
        return res;

    }

    private void back(int[] candidates, int target, int start, ArrayList<List<Integer>> res, ArrayList<Integer> temp) {
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(target < candidates[i]){
                break;
            }
            temp.add(candidates[i]);
            back(candidates, target - candidates[i], i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test(){
        combinationSum(new int[]{2,3,6,7}, 7);
    }
}
