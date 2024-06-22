package LeetCode.other;

import org.junit.Test;

public class CheckPerfectNumber {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for(int i=1;i<num;i++){
            if((num%i) == 0){
                sum += i;
            }
        }
        if(sum == num){
            return true;
        }else{
            return false;
        }

    }

    @Test
    public void test(){
    }
}
