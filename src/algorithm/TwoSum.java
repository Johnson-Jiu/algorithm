package algorithm;

import org.junit.Test;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if(map.containsKey(need)){
                if(map.get(need) == i){
                    continue;
                }
                res[0] = i;
                res[1] = map.get(need);
                return res;
            }
        }

        return res;

    }


    @Test
    public void test(){
        int[] ints = new int[3];
        ints[0] = 3;
        ints[1] = 2;
        ints[2] = 4;
        System.out.println(twoSum(ints,6));
    }
}
