package _1015;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> stack = new ArrayList<T>();

    public void add(T item) {
        stack.add(item);
    }
    public T pop() {
        if(stack.isEmpty()) return null;
        return stack.remove(stack.size()-1);
    }
}
