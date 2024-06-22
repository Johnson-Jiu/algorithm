package LeetCode.other;

import org.junit.Test;

/**
 * 1. 判断数偶： 奇数 x % 2 == 1 -> (x&1 == 1) 偶数x % 2 == 0 -> (x&1 == 0)
 *
 * 两数取平均(除2): mid = (left+right)/2 等价于 mid = (left+right) >> 1
 *
 * 清除最低位的1: x = x&(x-1)
 *
 * 得到最低位的1: n = x & -x
 *
 * 清零: x&~x
 */

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        x=x^y;
        y=0;//用y来记录个数
        while(x != 0){
            if(x%2 != 0) {
                y++;
            }
            x/=2;
        }
        return y;
    }

    @Test
    public void test(){
        System.out.println(hammingDistance(1,4));
    }
}
