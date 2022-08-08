package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 761. 特殊的二进制序列
 *
 * @author: shenxian
 * @date: 2022/8/8 10:30
 */
public class Solution {

    public String makeLargestSpecial(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }

        List<String> childs = new ArrayList<>();
        int count = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
                // 找到一个特殊子序列
                if (count == 0) {
                    childs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(childs, Comparator.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (String child : childs) {
            result.append(child);
        }
        return result.toString();
    }

}
