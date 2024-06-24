package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}

/*

        int[] res = new int[n+1];
        res[0] = 1;
                res[1] = 1;
                for (int i = 2; i < n+1; i++) {
        res[i] = res[i-1] + res[i-2];
        }
        return res[n];

        */
