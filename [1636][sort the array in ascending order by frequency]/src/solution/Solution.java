package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1636. 按照频率将数组升序排序
 *
 * @author: shenxian
 * @date: 2022/9/19 9:50
 */
public class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((a, b) -> {
            int aCnt = count.get(a);
            int bCnt = count.get(b);
            return aCnt != bCnt ? aCnt - bCnt : b - a;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

}
