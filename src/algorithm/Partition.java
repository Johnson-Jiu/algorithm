package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *分割回文串
 */
public class Partition {
    //存放所有集合
    List<List<String>> list;

    List<String> strList;

    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        list = new ArrayList();
        strList = new ArrayList();
        //开始递归
        dfs(0);
        return list;
    }
    private void dfs(int begin){
        //跳出循环条件
        if(begin > s.length() - 1){
            list.add(new ArrayList(strList));
            return;
        }
        //遍历
        for(int i = begin; i < s.length(); i++){
            //这里为什么是i+1，因为截取是左闭右开，所以+1本质上就是截取i位置
            //这里的起始必须使用的是begin不能是i否则会出现，你只能去获取一个字符的情况"e","f","e"这种
            //你必须再循环中当第一个字符符合，那么你可以继续递归，当单个的递归完你还要去将他的长度延展
            //{"e","ef"}, {"ef","e"},{"efe"}
            String str = s.substring(begin, i + 1);
            //判定当前字符是否是回文串，不是说明此路不通
            //（这里并不是最优解，因为按道理，只要有一个不符合就应该）直接return
            //但是会存在当{"ef"}不是回文的时候会结束，这样就无法获取"efe"了，所以必须使用continue
            //降低效率，保证完整度
            if(!checkStr(str)){
                continue;
            }
            strList.add(str);
            dfs(i + 1);
            //移除末位项
            strList.remove(strList.size() - 1);
        }

    }

    private boolean checkStr(String str){
        char[] letters = str.toCharArray();
        int begin = 0;
        int end = letters.length - 1;
        while(begin <= end){
            if(letters[begin] != letters[end]){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

}
