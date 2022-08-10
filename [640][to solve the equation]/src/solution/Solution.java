package solution;

/**
 * 640. 求解方程
 *
 * @author: shenxian
 * @date: 2022/8/10 9:26
 */
public class Solution {

    public String solveEquation(String equation) {
        String replace = equation.replace("-", "+-");
        String[] left = replace.split("=")[0].split("\\+");
        String[] right = replace.split("=")[1].split("\\+");

        // leftVal表示左边变量系数值 rightVal表示右边常量值
        int leftVal = 0, rightVal = 0;
        for (String s : left) {
            if ("x".equals(s)) {
                leftVal += 1;
            } else if ("-x".equals(s)) {
                leftVal -= 1;
            } else if (s.contains("x")) {
                leftVal += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!"".equals(s)){
                rightVal -= Integer.parseInt(s);
            }
        }

        for (String s : right) {
            if ("x".equals(s)) {
                leftVal -= 1;
            } else if ("-x".equals(s)) {
                leftVal += 1;
            } else if (s.contains("x")) {
                leftVal -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!"".equals(s)){
                rightVal += Integer.parseInt(s);
            }
        }

        if (leftVal == 0) {
            if (rightVal == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }

        return "x=" + rightVal / leftVal;
    }

}
