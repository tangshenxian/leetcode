package path;

/**
 * 576. 出界的路径数
 *
 * @author: shenxian
 * @date: 2022/8/24 14:12
 */
public class Solution576 {

    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int x, int y) {
        int[][][] f = new int[m][n][maxMove + 1];

        // 初始化有效值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    add(i, j, maxMove, f);
                }
                if (i == m - 1) {
                    add(i, j, maxMove, f);
                }
                if (j == 0) {
                    add(i, j, maxMove, f);
                }
                if (j == n - 1) {
                    add(i, j, maxMove, f);
                }
            }
        }

        // 定义上下左右四个方向
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // 枚举可移动步数
        for (int step = 1; step <= maxMove; step++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int nx = i + dir[0], ny = j + dir[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            f[i][j][step] += f[nx][ny][step - 1];
                            f[i][j][step] %= mod;
                        }
                    }
                }
            }
        }
        return f[x][y][maxMove];
    }

    /**
     * 初始化边缘位置的值
     */
    private void add(int i, int j, int max, int[][][] f) {
        for (int k = 1; k <= max; k++) {
            f[i][j][k]++;
        }
    }

}
