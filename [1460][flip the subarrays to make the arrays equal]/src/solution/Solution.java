package solution;

import java.util.Arrays;

/**
 * 1460. 通过翻转子数组使两个数组相等
 *
 * @author: shenxian
 * @date: 2022/8/24 9:49
 */
public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1010];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
            count[target[i]]--;
        }
        return Arrays.equals(count, new int[1010]);
    }

}
