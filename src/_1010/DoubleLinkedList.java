package _1010;

public class DoubleLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    class Node<T> {
        T data;
        Node<T> next = null;
        Node<T> prev = null;

        Node(T item) {
            this.data = item;
        }
    }

    public void add(T item) {
        if (this.head == null) {
            this.head = new Node<T>(item);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(item);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void print() {
        if (this.head == null) {
            System.out.println("no data");
        } else {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T target) {
        if (this.head == null) return null;
        Node<T> node = this.head;
        while (node != null) {
            if (node.data == target) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    public T searchFromTail(T target) {
        if (this.head == null) return null;
        Node<T> node = this.head;
        while (node != null) {
            if (node.data == target) {
                return node.data;
            }
            node = node.prev;
        }
        return null;
    }

    public boolean insertToFront(T item, T target) {
        if (this.head == target) {
            this.add(item);
            return true;
        } else if (this.head.data == target) {
            Node<T> newHead = new Node<>(item);
            newHead.next = this.head;
            this.head = newHead;
            this.head.next.prev = newHead;
            return true;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == target) {
                    Node<T> prev = node.prev;
                    prev.next = new Node<>(item);
                    prev.next.prev = prev;
                    prev.prev = prev.next;
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }
}
