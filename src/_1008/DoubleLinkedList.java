package _1008;

public class DoubleLinkedList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    class Node<T> {
        T data;
        Node<T> next = null;
        Node<T> prev = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        if (this.head == null) {
            this.head = new Node<>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void print() {
        if(this.head == null) {
            System.out.println("no data");
        } else {
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T target) {
        if(this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if(node.data == target) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public T searchFromTail(T target){
        if(this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while(node != null) {
                if(node.data == target) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
        }
        return null;
    }

    public boolean insertToFront(T data, T target) {
        if(this.head == null) {
            this.add(data);
            return true;
        } else if(this.head.data == target){
            Node<T> newHead = new Node<>(data);
            newHead.next = this.head;
            this.head = newHead;
            this.head.next.prev = this.head;
            return true;
        } else {
            Node<T> node = this.head;
            while(node != null) {
                if(node.data == target) {
                    Node<T> prev = node.prev;
                    prev.next = new Node<>(data);
                    prev.next.prev = prev;
                    prev.prev = prev.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
        }
        return false;
    }
}
