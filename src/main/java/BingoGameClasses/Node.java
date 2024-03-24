package BingoGameClasses;

/**
 *
 * @author zahid
 * @param <T>
 */
public class Node<T> {

    T data;
    Node<T> next;
    Node<T> prev;
    Node<T> down;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }

}
