package algorithm;


import org.junit.Test;

/**
 * 盛最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right){
            maxArea = Math.max((right - left) * Math.min(height[left], height[right]), maxArea);
            if(height[left] > height[right - 1]){
                right--;
                continue;
            }
            left++;
        }
        return maxArea;
    }

    @Test
    public void test(){
        int[] testInt = new int[]{1,8,100,2,100,4,8,3,7};
        maxArea(testInt);
    }
}
