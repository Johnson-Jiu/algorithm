package LeetCode.other;

public class CountSubstrings {
    public int countSubstrings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 2*s.length()-1; i++) {
            int l = i/2,r = i/2 + i%2;
            while (l >= 0 &&r < s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                res++;
            }
        }
        return res;
    }
}
