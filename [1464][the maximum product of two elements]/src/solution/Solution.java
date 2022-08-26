package solution;

/**
 * 1464. 数组中两元素的最大乘积
 *
 * @author: shenxian
 * @date: 2022/8/26 9:40
 */
public class Solution {

    public int maxProduct(int[] nums) {
        int a = -1, b = -1;
        for (int num : nums) {
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
        }
        return (a - 1) * (b - 1);
    }

}
