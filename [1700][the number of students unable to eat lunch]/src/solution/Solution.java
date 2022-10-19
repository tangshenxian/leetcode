package solution;

import java.util.Arrays;

/**
 * 1700. 无法吃午餐的学生数量
 *
 * @author: shenxian
 * @date: 2022/10/19 9:27
 */
public class Solution {

    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

}
