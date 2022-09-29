package solution;

/**
 * 面试题 01.09. 字符串轮转
 *
 * @author: shenxian
 * @date: 2022/9/29 11:21
 */
public class Solution {

    public boolean isFlipedString(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        if (n1 == 0) {
            return true;
        }
        return (s1 + s1).contains(s2);
    }

}
