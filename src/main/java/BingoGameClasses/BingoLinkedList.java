package BingoGameClasses;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 *
 * @author zahid
 * @param <T>
 */
public class BingoLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public BingoLinkedList() {
    }

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
        size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
            //return null;
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
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

    public boolean removeIf(Predicate<? super T> filter) {
        // Ensure the class is parameterized for type safety
        @SuppressWarnings("unchecked")
        Node<T> current = (Node<T>) head;
        Node<T> prev = null;
        boolean removed = false;

        while (current != null) {
            Node<T> next = current.next;
            if (filter.test(current.data)) {
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }
                if (next == null) {
                    tail = prev;
                }
                size--;
                removed = true;
            } else {
                prev = current;
            }
            current = next;
        }

        return removed;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T getWithDownNode(int index) {
        if (index >= size()) {
            // index is out of bounds
            return null;
        }
        Node<T> currentNode = head;
        int count = 0;
        while (count != index) {
            currentNode = (count % 5 == 4) ? currentNode.down : currentNode.next;
            count++;
        }
        return currentNode.data;
    }

    public void removeWithDownNode(T data) {
        Node<T> temp = head;
        Node<T> prev = null;
        while (temp != null) {
            if (temp.data.equals(data)) {
                if (temp == head) {
                    head = head.next;
                } else {
                    prev.down = (prev.down == null) ? prev.next = temp.next : temp.next;
                }
                size--;
                return;
            }
            prev = temp;
            temp = (temp.next == null && temp.down != null) ? temp.down : temp.next;
        }
    }

    public void addByIndex(int index, T data) {
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        int currentIndex = 0;
        while (current != null && currentIndex != index) {
            prev = current;
            current = (currentIndex % 5 == 4) ? current.down : current.next;
            currentIndex++;
        }

        if (index % 5 == 0) {
            prev.down = newNode;
        } else {
            prev.next = newNode;
        }
        newNode.next = current;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

}