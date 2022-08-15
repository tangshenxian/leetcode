package solution;

/**
 * 641. 设计循环双端队列
 *
 * @author: shenxian
 * @date: 2022/8/15 9:26
 */
public class MyCircularDeque {

    private int[] element;
    private int size;
    private int head;
    private int tail;

    public MyCircularDeque(int k) {
        element = new int[k + 1];
        size = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head + size - 1) % size;
        element[head] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        element[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail + size - 1) % size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return element[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return element[(tail + size - 1) % size];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

}
