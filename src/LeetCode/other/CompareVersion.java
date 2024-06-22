package LeetCode.other;

import org.junit.Test;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for(int i = 0;i < Math.max(split1.length,split2.length);i++){
            int j = i < split1.length ? Integer.valueOf(split1[i]) : 0;
            int k = i < split2.length ? Integer.valueOf(split2[i]) : 0;
            if(j > k){
                return 1;
            }else if(j < k){
                return -1;
            }
        }
        return 0;


    }

    @Test
    public void test(){
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
    }
}
