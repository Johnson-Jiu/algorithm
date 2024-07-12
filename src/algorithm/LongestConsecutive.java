package algorithm;

import org.junit.Test;

import java.util.HashSet;

/**
 * 最长连续序列
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if(set.isEmpty()){
            return 0;
        }
        int maxLength = 0;
        for (Integer num : set) {
            if(!set.contains(num - 1)){
                int y = num;
                while (set.contains(y + 1)){
                    y++;
                }
                maxLength = Math.max(maxLength, y - num + 1);
            }
        }
        return maxLength;
    }

/*    如何每次只枚举连续序列的起始数字x？

    其实只需要每次在哈希表中检查是否存在 x−1即可。如果x-1存在，说明当前数x不是连续序列的起始数字，我们跳过这个数。

    具体过程如下：

            1、定义一个哈希表hash，将nums数组中的数都放入哈希表中。
            2、遍历哈希表hash，如果当前数x的前驱x-1不存在，我们就以当前数x为起点向后枚举。
            3、假设最长枚举到了数y，那么连续序列长度即为y-x+1。
            4、不断枚举更新答案。

    作者：林小鹿
    链接：https://leetcode.cn/problems/longest-consecutive-sequence/solutions/925733/ha-xi-zui-qing-xi-yi-dong-de-jiang-jie-c-xpnr/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/



    @Test
    public void test(){
        longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});
    }
}
