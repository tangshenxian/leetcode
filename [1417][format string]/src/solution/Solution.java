package solution;

/**
 * 1417. 重新格式化字符串
 *
 * @author: shenxian
 * @date: 2022/8/11 15:11
 */
public class Solution {

    public static String reformat(String s) {
        StringBuilder number = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                letter.append(c);
            }
        }

        int a = number.length(), b = letter.length(), tot = a + b;
        if (Math.abs(a - b) > 1) return "";

        StringBuilder result = new StringBuilder();
        while (result.length() != tot) {
            if (a > b) {
                result.append(number.charAt(--a));
            } else if (a < b) {
                result.append(letter.charAt(--b));
            } else {// 数量相等
                if (result.length() > 0 && Character.isDigit(result.charAt(result.length() - 1))) {
                    result.append(letter.charAt(--b));
                } else {
                    result.append(number.charAt(--a));
                }
            }
        }
        return result.toString();
    }

}
