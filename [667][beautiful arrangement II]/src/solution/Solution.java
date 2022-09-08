package solution;

/**
 * 667. 优美的排列 II
 *
 * @author: shenxian
 * @date: 2022/9/8 14:41
 */
public class Solution {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int idx = 0;
        for (int i = 1; i < n - k; i++) {
            res[idx] = i;
            idx++;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            res[idx] = i;
            idx++;
            if (i != j) {
                res[idx] = j;
                idx++;
            }
        }
        return res;
    }

}
