package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenxian
 * @date: 2022/8/8 13:48
 */
public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

}
