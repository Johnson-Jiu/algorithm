package LeetCode.回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        back(res,candidates,new ArrayList<Integer>(),0,target);
        return res;

    }

    private void back(List<List<Integer>> res, int[] candidates, ArrayList<Integer> list, int begin,int target) {
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            back(res, candidates, list, i,target - candidates[i]);
            list.remove(list.size()-1);
        }
    }
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }
}




