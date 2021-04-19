package src.ch02_list;

import src.common.Node;

import java.util.NoSuchElementException;

public class CircularLinkedListImpl<E> implements CircularLinkedList<E> {

    private Node last;
    private int size;

    public CircularLinkedListImpl() {
        last = null;
        size = 0;
    }

    @Override
    public void insert(E newItem) {
        Node newNode = new Node(newItem, null);
        if (last == null) {
            newNode.setNext(newNode); // 자기 자신을 연결
            last = newNode;
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
            // last - newNode - first
        }
        size++;
    }

    @Override
    public Node delete() {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = last.getNext();
        if (x == last) last = null;
        else {
            last.setNext(x.getNext());
            x.setNext(null);
        }
        size--;
        return x;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
