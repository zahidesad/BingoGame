package BingoGameClasses;

import java.util.LinkedList;

/**
 *
 * @author zahid
 */
public class Node<T> {

    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
    }

}
