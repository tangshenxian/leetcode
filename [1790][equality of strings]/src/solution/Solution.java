package solution;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 *
 * @author: shenxian
 * @date: 2022/10/11 9:29
 */
public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                } else {
                    return false;
                }
            }
        }
        if (a == b && a == -1) {
            return true;
        }
        if (b == -1) {
            return false;
        }
        return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
    }

}
