package _1008;

public class SingleLinkedList<T> {
    Node<T> head = null;

    class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T item) {
        if (this.head != null) {
            Node node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(item);
        } else {
            this.head = new Node(item);
        }
    }

    public void print() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        } else {
            System.out.println("No data");
        }
    }

    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == data) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void addInside(T data, T target) {
        Node<T> search = this.search(target);
        if (search == null) {
            this.add(data);
        } else {
            Node<T> next = search.next;
            search.next = new Node<>(data);
            search.next.next = next;
        }
    }

    public boolean delete(T target) {
        if (this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if (node.data == target) {
                this.head = this.head.next;
                return true;
            } else {
                while (node.next != null) {
                    if (node.next.data == target) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
}
