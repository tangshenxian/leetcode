package solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 *
 * @author: shenxian
 * @date: 2022/8/8 11:08
 */
public class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            String type = split[1];
            int time = Integer.parseInt(split[2]);
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    // 暂停的任务执行的时间
                    int[] peek = stack.peek();
                    times[peek[0]] += time - peek[1];
                }
                stack.push(new int[]{id, time});
            } else {
                int[] pop = stack.pop();
                times[pop[0]] += time - pop[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = time + 1;
                }
            }
        }
        return times;
    }

}
