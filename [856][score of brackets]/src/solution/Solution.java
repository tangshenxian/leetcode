package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. 括号的分数
 *
 * @author: shenxian
 * @date: 2022/10/9 9:42
 */
public class Solution {

    public int scoreOfParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.addLast(0);
            } else {
                int cur = deque.pollLast();
                deque.addLast(Math.max(cur * 2, 1) + deque.pollLast());
            }
        }
        return deque.peekLast();
    }

}
