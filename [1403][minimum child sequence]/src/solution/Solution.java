package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 *
 * @author: shenxian
 * @date: 2022/8/4 10:39
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int current = 0;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i>= 0; --i) {
            result.add(nums[i]);
            current += nums[i];
            total -= nums[i];
            if (current > total) {
                break;
            }
        }
        return result;
    }

}
