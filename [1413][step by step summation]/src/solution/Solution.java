package solution;

/**
 * 1413. 逐步求和得到正数的最小值
 *
 * @author: shenxian
 * @date: 2022/8/9 9:38
 */
public class Solution {

    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(minSum, sum);
        }
        return -minSum + 1;
    }

}
