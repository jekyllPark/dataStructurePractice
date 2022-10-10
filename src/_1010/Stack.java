package _1010;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> stack = new ArrayList<>();

    public void add(T item) {
        stack.add(item);
    }

    public T remove() {
        return stack.isEmpty() ? null : stack.remove(stack.size() - 1);
    }
}
