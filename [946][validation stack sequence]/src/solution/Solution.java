package solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 *
 * @author: shenxian
 * @date: 2022/8/31 14:03
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            deque.addLast(pushed[i]);
            while (!deque.isEmpty() && deque.peekLast() == popped[j]) {
                deque.pollLast();
                j++;
            }
        }
        return deque.isEmpty();
    }

}
