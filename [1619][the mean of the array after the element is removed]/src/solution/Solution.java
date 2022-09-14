package solution;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 *
 * @author: shenxian
 * @date: 2022/9/14 9:39
 */
public class Solution {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            res += arr[i];
        }
        return res * 1.0 / (n * 0.9);
    }

}
