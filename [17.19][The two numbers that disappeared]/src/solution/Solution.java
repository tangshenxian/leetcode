package solution;

/**
 * 面试题 17.19. 消失的两个数字
 *
 * @author: shenxian
 * @date: 2022/9/26 15:47
 */
public class Solution {

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2, sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        int t = sum / 2, cur = sum;
        sum = t * (t + 1) / 2;
        for (int num : nums) {
            if (num <= t) {
                sum -= num;
            }
        }
        return new int[]{sum, cur - sum};
    }

}
