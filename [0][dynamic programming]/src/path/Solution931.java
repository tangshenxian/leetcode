package path;

/**
 * 931. 下降路径最小和
 *
 * @author: shenxian
 * @date: 2022/8/17 16:49
 */
public class Solution931 {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = matrix[0][i];
        }
        // 从第一行开始
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                // 正上方
                f[i][j] = f[i - 1][j] + val;
                // 左上方
                if (j > 0) {
                    f[i][j] = Math.min(f[i - 1][j - 1] + val, f[i][j]);
                }
                // 右上方
                if (j + 1 < n) {
                    f[i][j] = Math.min(f[i - 1][j + 1] + val, f[i][j]);
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
