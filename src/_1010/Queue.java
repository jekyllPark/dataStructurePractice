package _1010;

import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> queue = new ArrayList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.isEmpty() ? null : queue.remove(0);

    }
}
