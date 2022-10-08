package _1008;

import java.util.ArrayList;

public class Queue<T> {
    ArrayList<T> queue = new ArrayList<>();

    public void enqueue (T item) {
        queue.add(item);
    }

    public T remove() {
        if(queue.isEmpty()) return null;
        return queue.remove(0);
    }
}
