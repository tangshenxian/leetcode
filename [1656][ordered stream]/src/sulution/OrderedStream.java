package sulution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. 设计有序流
 *
 * @author: shenxian
 * @date: 2022/8/16 9:28
 */
public class OrderedStream {

    private String[] elements;
    private int ptr;

    public OrderedStream(int n) {
        this.elements = new String[n + 1];
        this.ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        elements[idKey] = value;
        List<String> res = new ArrayList<>();
        while (ptr < elements.length && elements[ptr] != null) {
            res.add(elements[ptr]);
            ptr++;
        }
        return res;
    }

}
