package path;

import java.util.List;

/**
 * 1301. 最大得分的路径数目
 *
 * @author: shenxian
 * @date: 2022/8/24 15:57
 */
public class Solution1301 {

    int mod = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int[] xxx = new int[]{Integer.MIN_VALUE, 0};

        int n = board.size();

        // 初始化为二维数组
        char[][] g = new char[n][n];
        for (int i = 0; i < board.size(); i++) {
            g[i] = board.get(i).toCharArray();
        }

        // f[i][j][0]表示位置(i, j)的最大得分数，f[i][j][1]表示位置(i, j)的最大得分的方案数
        int[][][] f = new int[n][n][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 右下角起点初始化
                if (i == n - 1 && j == n - 1) {
                    f[i][j][1] = 1;
                    continue;
                }

                // 障碍X
                if (g[i][j] == 'X') {
                    f[i][j][0] = Integer.MIN_VALUE;
                    f[i][j][1] = 0;
                    continue;
                }

                // 下边
                int[] bottom = i + 1 < n ? f[i + 1][j] : xxx;
                // 右边
                int[] right = j + 1 < n ? f[i][j + 1] : xxx;
                // 右下方
                int[] rightBottom = (i + 1 < n && j + 1 < n) ? f[i + 1][j + 1] : xxx;

                int val = Character.isDigit(g[i][j]) ? g[i][j] - '0' : 0;
                // 拿到三个位置的最大得分数
                int max = Math.max(bottom[0], Math.max(right[0], rightBottom[0]));
                if (max == Integer.MIN_VALUE) {
                    f[i][j][0] = Integer.MIN_VALUE;
                    f[i][j][1] = 0;
                } else {
                    f[i][j][0] = max + val;
                    if (max == bottom[0]) {
                        f[i][j][1] += bottom[1];
                    }
                    if (max == right[0]) {
                        f[i][j][1] += right[1];
                    }
                    if (max == rightBottom[0]) {
                        f[i][j][1] += rightBottom[1];
                    }
                    f[i][j][1] %= mod;
                }
            }
        }
        return f[0][0][0] == Integer.MIN_VALUE ? new int[]{0, 0} : f[0][0];
    }

}
