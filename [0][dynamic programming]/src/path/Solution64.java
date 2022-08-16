package path;

/**
 * 64. 最小路径和
 *
 * @author: shenxian
 * @date: 2022/8/16 9:40
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    f[i][j] = f[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    f[i][j] = f[i][j - 1] + grid[i][j];
                }
            }
        }
        return f[m - 1][n - 1];
    }

}
