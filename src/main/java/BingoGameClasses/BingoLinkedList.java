package BingoGameClasses;

import java.util.Random;

/**
 *
 * @author zahid
 */
public class BingoLinkedList<T extends Comparable<T>> {

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

    public T getLast() {
        if (tail != null) {
            return tail.data;
        }
        return null;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    void print() {
            Node current = head;
            int counter = 0;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
                counter++;
                if(counter % 5 == 0) {
                    System.out.println();
                }
            }
        }

    public void shuffle() {
        Random rnd = new Random();
        for (int i = size - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            swap(index, i);
        }
    }

    private void swap(int i, int j) {
        T temp = getNode(i).data;
        getNode(i).data = getNode(j).data;
        getNode(j).data = temp;
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        Node<T> current = head, index = null;
        T temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data.compareTo(index.data) > 0) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // Diğer bir linked listi bu listenin sonuna ekler
    public void addAll(BingoLinkedList otherList) {
        if (otherList.head == null) {
            return;
        }

        if (head == null) {
            head = otherList.head;
            tail = otherList.tail;
        } else {
            tail.next = otherList.head;
            otherList.head.prev = tail;
            tail = otherList.tail;
        }
        size += otherList.size;
    }

}
