package solution;

/**
 * 779. 第K个语法符号
 *
 * @author: shenxian
 * @date: 2022/10/20 11:17
 */
public class Solution {

    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k > (1 << (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }

}
