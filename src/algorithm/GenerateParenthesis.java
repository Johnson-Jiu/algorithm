package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        def(n, n, "");
        return res;
    }

    private void def(int n, int m, String s) {
        //// 字符串构建完成,括号用完了
        if(n == 0 && m == 0){
            res.add(s);
            return;
        }
        //只要左括号有剩，可以选它，继续递归做选择
        if(n > 0){
            def(n-1, m, s + "(");
        }
        //只有右括号的保有数量大于左括号的保有数量，才能选右括号，否则肯定不能构成有效括号
        if(m > n){
            def(n, m-1, s + ")");
        }
    }
}
