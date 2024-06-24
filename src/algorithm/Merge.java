package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        //获取数组长度
        int length = intervals.length;
        //初始化一个新的数组存放合并后的值，但是长度可能存在多余
        int[][] merge = new int[length][2];
        //对数组的左端点进行排序
        Arrays.sort(intervals,(x,y)->{
            return x[0] - y[0];
        });
        //将第一个值直接放入数组初始化
        merge[0] = intervals[0];
        //新数组中最后一个元素下标的位置
        int index = 0;
        //循环遍历
        for(int i = 1; i < length; i++){
            //因为数组中的左端点已经按照从大到小的顺序排列
            //那么当新数组中最后一个右端点如果小于当前元素的左端点，那么一定不重合，
            //直接加入新的数组集合，否则就是一定会有重合需要合并的
            if(intervals[i][0] > merge[index][1]){
                merge[++index] = intervals[i];
            }else{
                //这里要获取两个右端点的最大值作为合并后的右端点，
                //因为左端点排序之后你不知道右端点到底是大是小的。
                merge[index][1] = Math.max(intervals[i][1], merge[index][1]);
            }
        }
        //这里copy新的数组是因为原来的初始化的merge数组是最大长度length，这样如果
        //存在合并的数组之后，那么merge就存在了[0,0]这种给的元素，这样是不符合要求的
        //所以重新复制一个新的数组，长度是index+1是因为index是实际元素的下标，
        //如果变成长度要+1
        return Arrays.copyOf(merge, index+1);
    }
}

