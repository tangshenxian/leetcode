package solution;

/**
 * 940. 不同的子序列 II
 *
 * @author: shenxian
 * @date: 2022/10/14 9:43
 */
public class Solution {

    public int distinctSubseqII(String s) {
        final int mod = 1000000007;
        // 之前新增的个数就是重复的个数
        int[] preCount = new int[26];
        char[] chs = s.toCharArray();
        int ans = 1, n = chs.length;
        for (int i = 0; i < n; i++) {
            // 新增的个数
            int newCount = ans;
            // 个数 = 之前的个数 + 新增的个数 - 重复的个数
            ans = ((ans + newCount) % mod - (preCount[chs[i] - 'a']) % mod + mod) % mod;
            // 当前字符的新增数
            preCount[chs[i] - 'a'] = newCount;
        }
        // 减去空串
        return ans - 1;
    }

}
