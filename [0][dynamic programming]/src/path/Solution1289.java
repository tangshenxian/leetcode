package path;

/**
 * @author: shenxian
 * @date: 2022/8/19 9:43
 */
public class Solution1289 {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                int val = grid[i][j];
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        f[i][j] = Math.min(f[i - 1][k] + val, f[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, f[n - 1][i]);
        }
        return min;
    }

}
