package solution;

/**
 * 1822. 数组元素积的符号
 *
 * @author: shenxian
 * @date: 2022/10/27 9:23
 */
public class Solution {

    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign = -sign;
            }
        }
        return sign;
    }

}
