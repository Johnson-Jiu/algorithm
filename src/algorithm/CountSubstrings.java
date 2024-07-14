package algorithm;

/**
 * 647.回文子串 的数目
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for (int center = 0; center < n; center++) {
            //以单个字符或者双字符拓展
            ans += expand(s, center, center) + expand(s, center, center + 1);
        }
        return ans;
    }

    private int expand(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ans++;
            left--;
            right++;
        }
        return ans;
    }
}
