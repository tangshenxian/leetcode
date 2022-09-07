package backpack;

/**
 * 1155. 掷骰子的N种方法
 *
 * @author: shenxian
 * @date: 2022/9/7 14:30
 */
public class Solution1155 {

    int mod = 1000000007;

    public int numRollsToTarget3(int n, int k, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = 0;
                for (int l = 1; l <= k; l++) {
                    if (j >= l) {
                        dp[j] = (dp[j] + dp[j - l]) % mod;
                    }
                }
            }
        }
        return dp[target];
    }

    public int numRollsToTarget2(int n, int k, int target) {
        int[][] dp = new int[2][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int a = i & 1, b = (i - 1) & 1;
            for (int j = 0; j <= target; j++) {
                dp[a][j] = 0;
                for (int l = 1; l <= k; l++) {
                    if (j >= l) {
                        dp[a][j] = (dp[a][j] + dp[b][j - l]) % mod;
                    }
                }
            }
        }
        return dp[n & 1][target];
    }

    public int numRollsToTarget1(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j >= l) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }

}
