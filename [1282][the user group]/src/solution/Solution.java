package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 *
 * @author: shenxian
 * @date: 2022/8/12 9:35
 */
public class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // key-组大小 value-组数据
        Map<Integer, List<Integer>> map = new HashMap<>(8);
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> value = map.getOrDefault(groupSizes[i], new ArrayList<>());
            value.add(i);
            map.put(groupSizes[i], value);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            List<Integer> ele = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                ele.add(list.get(i));
                if (ele.size() == key) {
                    result.add(ele);
                    ele = new ArrayList<>();
                }
            }
        }
        return result;
    }

}
