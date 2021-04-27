package ch03_Queue;

import src.common.Node;

import java.util.NoSuchElementException;

public class ListQueueImpl<E> implements ListQueue<E> {

    private Node<E> front, rear;
    private int size;

    public ListQueueImpl() {
        front = rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(E newItem) { // rear에 삽입
        Node newNode = new Node(newItem, null);
        if (isEmpty()) front = newNode;
        else rear.setNext(newNode);
        rear = newNode;
        size++;
    }

    @Override
    public E remove() { // front를 삭제
        if (isEmpty()) throw new NoSuchElementException();

        E frontItem = front.getItem();
        front = front.getNext();
        size--;
        if (isEmpty()) rear = null;
        return frontItem;
    }
}
