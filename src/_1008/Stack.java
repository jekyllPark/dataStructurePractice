package _1008;

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> stack = new ArrayList<>();

    public void add(T item){
        stack.add(item);
    }

    public T remove() {
        if(stack.isEmpty()) return null;
        return stack.remove(stack.size()-1);
    }
}
