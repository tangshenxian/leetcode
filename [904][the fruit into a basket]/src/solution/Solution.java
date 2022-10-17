package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 *
 * @author: shenxian
 * @date: 2022/10/17 9:32
 */
public class Solution {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(right - left + 1, ans);
        }
        return ans;
    }

}
