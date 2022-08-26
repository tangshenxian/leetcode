package backpack;

/**
 * 0-1背包
 *
 * @author: shenxian
 * @date: 2022/8/25 15:06
 */
public class Backpack01 {

    /**
     * dp[N][V + 1]解法
     *
     * @param N /
     * @param V /
     * @param v /
     * @param w /
     * @return /
     */
    public int solution1(int N, int V, int[] v, int[] w) {
        int[][] f = new int[N][V + 1];
        // 先枚举第一件物品的状态
        for (int i = 0; i <= V; i++) {
            f[0][i] = i >= v[0] ? v[0] : 0;
        }
        // 再枚举其他物品
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < V + 1; j++) {
                // bu选第i件物品
                int val1 = f[i - 1][j];
                // 选第i件物品,前提是容量足够
                int val2 = j >= v[i] ? f[i - 1][j - v[i]] + w[i] : 0;
                f[i][j] = Math.max(val1, val2);
            }
        }
        return f[N - 1][V];
    }

    /**
     * dp[2][C + 1]解法
     *
     * @param N /
     * @param V /
     * @param v /
     * @param w /
     * @return /
     */
    public int solution2(int N, int V, int[] v, int[] w) {
        int[][] f = new int[2][V + 1];
        // 先枚举第一件物品的状态
        for (int i = 0; i <= V; i++) {
            f[0][i] = i >= v[0] ? v[0] : 0;
        }
        // 再枚举其他物品
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < V + 1; j++) {
                // bu选第i件物品
                int val1 = f[(i - 1) & 1][j];
                // 选第i件物品,前提是容量足够
                int val2 = j >= v[i] ? f[(i - 1) & 1][j - v[i]] + w[i] : 0;
                f[i & 1][j] = Math.max(val1, val2);
            }
        }
        return f[(N - 1) & 1][V];
    }

    /**
     * dp[C + 1]解法
     *
     * @param N /
     * @param V /
     * @param v /
     * @param w /
     * @return /
     */
    public int solution3(int N, int V, int[] v, int[] w) {
        int[] f = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j < V - v[i]; j++) {
                // 不选该物品
                int val1 = f[j];
                // 选择该物品
                int val2 = f[j - v[i]] + w[i];
                f[j] = Math.max(val1, val2);
            }
        }
        return f[V];
    }

}
