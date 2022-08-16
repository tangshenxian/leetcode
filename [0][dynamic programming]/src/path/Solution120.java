package path;

import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author: shenxian
 * @date: 2022/8/16 9:58
 */
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                if (j == 0) {
                    f[i][j] = f[i - 1][j] + val;
                } else if (j == i) {
                    f[i][j] = f[i - 1][j - 1] + val;
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + val;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, f[n - 1][i]);
        }
        return res;
    }

}
