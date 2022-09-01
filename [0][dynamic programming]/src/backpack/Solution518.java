package backpack;

/**
 * 518. 零钱兑换 II
 *
 * @author: shenxian
 * @date: 2022/9/1 13:58
 */
public class Solution518 {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                f[j] += f[j - val];
            }
        }
        return f[amount];
    }

    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // 不选该零钱
                f[i][j] = f[i - 1][j];
                // 选择该零钱
                for (int k = 1; k * val <= j; k++) {
                    f[i][j] += f[i - 1][j - k * val];
                }
            }
        }
        return f[n][amount];
    }

}
