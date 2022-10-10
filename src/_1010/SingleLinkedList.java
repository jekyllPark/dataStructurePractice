package _1010;

public class SingleLinkedList<T> {
    Node<T> head = null;

    class Node<T> {
        T data;
        Node<T> next = null;

        Node(T data) {
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
            node.next = new Node<>(item);
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

    public void addInside(T item, T target) {
        Node<T> searchedNode = this.search(target);
        if(searchedNode == null) {
            this.add(item);
        } else {
            Node<T> next = searchedNode.next;
            searchedNode.next = new Node<>(item);
            searchedNode.next.next = next;
        }
    }

    public boolean delete(T target) {
        if (this.head != null) {
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
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> s = new SingleLinkedList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);

        s.print();
        System.out.println("=================================");
        s.addInside(6,5);

        s.print();
        System.out.println("=================================");

        s.delete(2);

        s.print();
    }
}
