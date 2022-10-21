package solution;

import java.util.Stack;

/**
 * 901. 股票价格跨度
 *
 * @author: shenxian
 * @date: 2022/10/21 9:42
 */
public class StockSpanner {

    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack<>();
        weights = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && price >= prices.peek()) {
            prices.pop();
            w += weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }

}
