package ch02_LinkedList;

import src.common.Node;

import java.util.NoSuchElementException;

public class SinglyLinkedListImpl<E> implements SinglyLinkedList<E> {

    protected Node head;
    private int size;

    public SinglyLinkedListImpl() {
        head = null;
        size = 0;
    }

    @Override
    public int search(E target) {
        Node p = head;
        for (int k = 0; k < size; k++) {
            if (target == p.getItem()) return k;
            p = p.getNext();
        }
        return -1;
    }

    @Override
    public void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++;
    }

    @Override
    public void insertLast(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    @Override
    public void deleteFront() {
        if (isEmpty()) throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

}
