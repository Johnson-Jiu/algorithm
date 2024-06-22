package algorithm;

import java.util.HashMap;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

/**
 * @author Mr Wrong
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else{
                map.put(nums[i], nums[i]);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            return integer;
        }
        return 1;
    }

}
