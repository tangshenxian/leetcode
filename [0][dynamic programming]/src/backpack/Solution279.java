package backpack;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. 完全平方数
 *
 * @author: shenxian
 * @date: 2022/8/29 15:03
 */
public class Solution279 {

    int INF = -1;

    public int numSquares(int n) {
        // 初始化完全平方数
        List<Integer> nums = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            nums.add(idx * idx);
            idx++;
        }

        int length = nums.size();

        int[] f = new int[n + 1];
        // 处理第一个完全平方数
        for (int j = 0; j <= n; j++) {
            int t = nums.get(0);
            int k = j / t;
            // 能满足k个数填满当前容量
            if (k * t == j) {
                f[j] = k;
            } else {
                f[j] = INF;
            }
        }

        for (int i = 1; i < length; i++) {
            int t = nums.get(i);
            for (int j = t; j <= n; j++) {
                if (f[j - t] != INF) {
                    f[j] = Math.min(f[j], f[j - t] + 1);
                }
            }
        }
        return f[n];
    }

    public int numSquares2(int n) {
        // 初始化完全平方数
        List<Integer> nums = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            nums.add(idx * idx);
            idx++;
        }

        int length = nums.size();

        int[][] f = new int[length][n + 1];
        // 处理第一个完全平方数
        for (int j = 0; j <= n; j++) {
            int t = nums.get(0);
            int k = j / t;
            // 能满足k个数填满当前容量
            if (k * t == j) {
                f[0][j] = k;
            } else {
                f[0][j] = INF;
            }
        }

        for (int i = 1; i < length; i++) {
            int t = nums.get(i);
            for (int j = 0; j <= n; j++) {
                // 不选第i个数
                f[i][j] = f[i - 1][j];
                // 选第i个数
                for (int k = 0; k * t <= j; k++) {
                    if (f[i - 1][j - k * t] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - k * t] + k);
                    }
                }
            }
        }
        return f[length - 1][n];
    }

}
