package _1015;

public class SingleLinkedList<T> {
    Node head = null;

    class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T item) {
        if (this.head == null) {
            this.head = new Node<>(item);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(item);
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

    public Node<T> search(T target) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == target) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void addNext(T item, T target) {
        Node<T> search = this.search(target);
        if (search == null) {
            this.add(item);
        } else {
            Node<T> next = search.next;
            search.next = new Node<>(item);
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
            }
            return false;
        }
    }
}
