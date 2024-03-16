package BingoGameClasses;

/**
 *
 * @author zahid
 */
public class BingoLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    public void addToFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addToEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void insertAfter(T key, T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                newNode.next = current.next;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                newNode.prev = current;
                if (current == tail) {
                    tail = newNode;
                }
                break;
            }
            current = current.next;
        }
        size++;
    }

    public void remove(T key) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    if (head == null) {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    public void set(int index, T data) {
        Node<T> node = getNode(index);
        if (node != null) {
            node.data = data;
        }
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; current != null && i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
