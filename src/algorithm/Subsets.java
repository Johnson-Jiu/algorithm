package algorithm;

import java.util.ArrayList;
import java.util.List;


/**
 * 子集
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>(); // 解集
        lists.add(new ArrayList<Integer>()); // 首先将空集加入解集中
        for(int i = 0; i < nums.length; i++){
            int size = lists.size(); // 当前子集数
            for(int j = 0; j < size; j++){
                List<Integer> newList = new ArrayList<>(lists.get(j));// 拷贝所有子集
                newList.add(nums[i]); // 向拷贝的子集中加入当前数形成新的子集
                lists.add(newList); // 向lists中加入新子集
            }
        }
        return lists;
    }
}

/*
可以这么表示，dp[i]表示前i个数的解集，dp[i] = dp[i - 1] + collections(i)。其中，collections(i)表示把dp[i-1]的所有子集都加上第i个数形成的子集。

        【具体操作】

        因为nums大小不为0，故解集中一定有空集。令解集一开始只有空集，然后遍历nums，每遍历一个数字，拷贝解集中的所有子集，将该数字与这些拷贝组成新的子集再放入解集中即可。时间复杂度为O(n^2)。

        例如[1,2,3]，一开始解集为[[]]，表示只有一个空集。
        遍历到1时，依次拷贝解集中所有子集，只有[]，把1加入拷贝的子集中得到[1]，然后加回解集中。此时解集为[[], [1]]。
        遍历到2时，依次拷贝解集中所有子集，有[], [1]，把2加入拷贝的子集得到[2], [1, 2]，然后加回解集中。此时解集为[[], [1], [2], [1, 2]]。
        遍历到3时，依次拷贝解集中所有子集，有[], [1], [2], [1, 2]，把3加入拷贝的子集得到[3], [1, 3], [2, 3], [1, 2, 3]，然后加回解集中。此时解集为[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]。
*/
