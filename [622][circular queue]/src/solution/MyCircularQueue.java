package solution;

/**
 * 622. 设计循环队列
 *
 * @author: shenxian
 * @date: 2022/8/3 14:08
 */
public class MyCircularQueue {

    private int front;
    private int rear;
    private int capacity;
    private int[] elements;

    public MyCircularQueue(int k) {
        this.front = 0;
        this.rear = 0;
        this.capacity = k + 1;
        this.elements = new int[this.capacity];
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        this.elements[this.rear] = value;
        this.rear = (this.rear + 1) % this.capacity;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.capacity;
        return true;
    }

    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.elements[this.front];
    }

    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.elements[(this.rear - 1 + this.capacity) % this.capacity];
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return this.front == (this.rear + 1) % this.capacity;
    }

}
