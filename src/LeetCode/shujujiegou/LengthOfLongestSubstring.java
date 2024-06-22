package LeetCode.shujujiegou;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    //"aabcabcbb" "pwwkew" "ckilbkd"
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;


    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
