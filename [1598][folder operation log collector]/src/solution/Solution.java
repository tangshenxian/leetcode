package solution;

/**
 * 1598. 文件夹操作日志搜集器
 *
 * @author: shenxian
 * @date: 2022/9/9 14:23
 */
public class Solution {

    public int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                count = Math.max(0, count - 1);
            } else if (!"./".equals(log)) {
                count++;
            }
        }
        return count;
    }

}
