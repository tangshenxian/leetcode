package solution;

import java.util.Arrays;

/**
 * 828. 统计子串中的唯一字符
 *
 * @author: shenxian
 * @date: 2022/9/7 9:15
 */
public class Solution {

    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        int[] l = new int[n], r = new int[n];
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for (int i = 0; i < n; i++) {
            int u = cs[i] - 'A';
            l[i] = idx[u];
            idx[u] = i;
        }
        Arrays.fill(idx, n);
        for (int i = n - 1; i >= 0; i--) {
            int u = cs[i] - 'A';
            r[i] = idx[u];
            idx[u] = i;
        }
        for (int i = 0; i < n; i++) {
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;
    }

}
