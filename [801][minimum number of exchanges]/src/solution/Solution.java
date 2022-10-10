package solution;

/**
 * 801. 使序列递增的最小交换次数
 *
 * @author: shenxian
 * @date: 2022/10/10 14:31
 */
public class Solution {

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] f = new int[n][2];
        for (int i = 0; i < n; i++) {
            f[i][0] = f[i][1] = Integer.MAX_VALUE;
        }
        f[0][0] = 0;
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i][1], f[i - 1][0] + 1);
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }

}
