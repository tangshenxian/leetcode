package backpack;

/**
 * 416. 分割等和子集
 *
 * @author: shenxian
 * @date: 2022/8/26 10:24
 */
public class Solution416 {

    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        // 奇数直接false
        if (target * 2 != sum) {
            return false;
        }

        int[][] f = new int[n][target + 1];

        // 初始化第一个数字有效值
        for (int i = 0; i <= target; i++) {
            f[0][i] = nums[0] <= i ? nums[0] : 0;
        }

        // 从第二个数字开始
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j <= target; j++) {
                // 不选第i个数字
                int val1 = f[i - 1][j];
                // 选第i个数字
                int val2 = j >= t ? f[i - 1][j - t] + t : 0;
                f[i][j] = Math.max(val1, val2);
            }
        }
        return f[n - 1][target] == target;
    }

    /**
     * 滚动数组
     *
     * @param nums /
     * @return /
     */
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        // 奇数直接false
        if (target * 2 != sum) {
            return false;
        }

        int[][] f = new int[2][target + 1];

        // 初始化第一个数字有效值
        for (int i = 0; i <= target; i++) {
            f[0][i] = nums[0] <= i ? nums[0] : 0;
        }

        // 从第二个数字开始
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j <= target; j++) {
                // 不选第i个数字
                int val1 = f[(i - 1) & 1][j];
                // 选第i个数字
                int val2 = j >= t ? f[(i - 1) & 1][j - t] + t : 0;
                f[i & 1][j] = Math.max(val1, val2);
            }
        }
        return f[(n - 1) & 1][target] == target;
    }

    /**
     * 一维数组优化
     *
     * @param nums /
     * @return /
     */
    public boolean canPartition3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        // 奇数直接false
        if (target * 2 != sum) {
            return false;
        }

        int[] f = new int[target + 1];
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            for (int j = target; j >= 0; j--) {
                // 不选该数字
                int val1 = f[j];
                // 选该数字
                int val2 = j >= t ? f[j - t] + t : 0;
                f[j] = Math.max(val1, val2);
            }
        }
        return f[target] == target;
    }

}
