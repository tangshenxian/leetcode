package solution;

/**
 * 915. 分割数组
 *
 * @author: shenxian
 * @date: 2022/10/24 9:42
 */
public class Solution {

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] min = new int[n + 10];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            if (max <= min[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

}
