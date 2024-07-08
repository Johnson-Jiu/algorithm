package algorithm;

import org.junit.Test;

import java.util.*;

/**
 * 单词拆分
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(res[j] && wordSet.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }

/*

    以题中 leetcode ['leet','code']为例

    第一轮判断：l

    第二轮判断：le e

    第三轮判断：lee ee e

    第四轮判断：leet (存在字典表中，设置dp[4]为true直接break)

    第五轮判断：leetc eetc etc tc c

    第六轮判断：leetco ettco ttco tco co o

    第七轮判断：leetcod eetcod etcod tcod cod od d

    第八轮判断：leetcode ettcode ttcode tcode code(找到，且dp[4]为true, 子串A存在+子串B存在)

    此次循环把leetcode所有子集循环判断，先从大子集开始，找到之后则跳出，不判断后续大子集分裂出的小子集（第四步）
*/

    @Test
    public void test(){
        wordBreak("leetcode", new ArrayList<String>(Arrays.asList("leet", "code")));
    }
}
