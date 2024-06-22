package LeetCode.双指针;

public class MaxArea {
    public int maxArea(int[] height) {
        if(height.length <= 1) return -1;
        int left = 0,right = height.length-1;
        int res = 0;
        while (left < right){
            res = Math.max(res,(right-left)*Math.min(height[left],height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
