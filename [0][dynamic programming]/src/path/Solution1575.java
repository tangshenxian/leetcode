package path;

import java.util.Arrays;

/**
 * 1575. 统计所有可行路径
 *
 * @author: shenxian
 * @date: 2022/8/23 10:01
 */
public class Solution1575 {

    int mod = 1000000007;
    int[][] cache;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        // 油量+1是因为避免下标从0开始的+1计算
        cache = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    private int dfs(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        // 如果缓存器中存在值，直接返回
        if (cache[start][fuel] != -1) {
            return cache[start][fuel];
        }

        // 1. 如果油量为0并且没有到达终点，将结果0写入缓存器中并返回
        if (fuel == 0 && start != finish) {
            cache[start][fuel] = 0;
            return 0;
        }
        // 2. 如果油量不为0并且无法到达任一位置，将结果0写入缓存器中并返回
        boolean hasNext = false;
        for (int i = 0; i < n; i++) {
            if (i != start) {
                // 到达位置i所需要的油量
                int need = Math.abs(locations[start] - locations[i]);
                // fuel >= need -> 能到达位置i
                if (fuel >= need) {
                    hasNext = true;
                    break;
                }
            }
        }
        if (fuel != 0 && !hasNext) {
            cache[start][fuel] = start == finish ? 1 : 0;
            return cache[start][fuel];
        }

        // 计算油量为fuel，到达位置finish的路径数量
        // 一个位置可以经过多次，如果start == finish的话算一条路径
        int sum = start == finish ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != start) {
                int need = Math.abs(locations[start] - locations[i]);
                if (fuel >= need) {
                    sum += dfs(locations, i, finish, fuel - need);
                    sum %= mod;
                }
            }
        }
        // 将结果写入缓存器
        cache[start][fuel] = sum;
        return sum;
    }

    public int countRoutesDp(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;

        // f[i][j]代表从位置i出发，油量为j的情况下到达目的地路径数量
        int[][] f = new int[n][fuel + 1];

        // 如果其实位置等于目的地，本身就算一条路径
        for (int i = 0; i <= fuel; i++) {
            f[finish][i] = 1;
        }

        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        int need = Math.abs(locations[i] - locations[k]);
                        if (cur >= need) {
                            f[i][cur] += f[k][cur - need];
                            f[i][cur] %= mod;
                        }
                    }
                }
            }
        }
        return f[start][fuel];
    }

}
