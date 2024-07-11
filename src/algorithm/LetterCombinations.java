package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<String, String[]> map = new HashMap<>();
        map.put("2", new String[]{"a","b","c"});
        map.put("3", new String[]{"d","e","f"});
        map.put("4", new String[]{"g","h","i"});
        map.put("5", new String[]{"j","k","l"});
        map.put("6", new String[]{"m","n","o"});
        map.put("7", new String[]{"p","q","r","s"});
        map.put("8", new String[]{"t","u","v"});
        map.put("9", new String[]{"w","x","y","z"});
        if(digits.isEmpty()){
            return res;
        }
        String temp = "";
        int size = digits.length();
        back(size, digits, map, res, temp, 0);
        return res;
    }

    private void back(int size, String digits, HashMap<String, String[]> map, List<String> res, String temp, int start) {
        if(size == temp.length()){
            res.add(temp);
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            String[] str = map.get(digits.charAt(i) + "");
            for (int j = 0; j < str.length; j++) {
                temp += str[j];
                back(size, digits, map, res, temp, i+1);
                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }

    @Test
    public void test(){
        letterCombinations("23");
    }
}
