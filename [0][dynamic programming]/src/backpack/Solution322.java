package backpack;

/**
 * 322. 零钱兑换
 *
 * @author: shenxian
 * @date: 2022/8/31 14:33
 */
public class Solution322 {

    int INF = Integer.MAX_VALUE;

    int INF2 = 0x3f3f3f3f;

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[] f = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            f[i] = INF2;
        }

        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                f[j] = Math.min(f[j], f[j - val] + 1);
            }
        }
        return f[amount] == INF2 ? -1 : f[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];

        for (int i = 1; i <= amount; i++) {
            f[0][i] = INF;
        }

        // 从前一个物品开始
        for (int i = 1; i <= n; i++) {
            int t = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // 不选该物品
                f[i][j] = f[i - 1][j];
                // 选该物品
                for (int k = 1; k * t <= j; k++) {
                    if (f[i - 1][j - k * t] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - k * t] + k);
                    }
                }
            }
        }
        return f[n][amount] == INF ? -1 : f[n][amount];
    }

}
