package solution;

/**
 * 面试题 01.02. 判定是否互为字符重排
 *
 * @author: shenxian
 * @date: 2022/9/27 9:17
 */
public class Solution {

    public boolean CheckPermutation(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 != n2) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < n1; i++) {
            table[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n2; i++) {
            table[s2.charAt(i) - 'a']--;
            if (table[s2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
