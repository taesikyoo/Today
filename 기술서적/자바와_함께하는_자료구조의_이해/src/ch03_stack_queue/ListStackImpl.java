package src.ch03_stack_queue;

import src.common.Node;

import java.util.EmptyStackException;

public class ListStackImpl<E> implements ListStack<E> {

    private Node<E> top;
    private int size; // 스택 사이즈를 노드만으로 바로 파악하기 힘드니까

    public ListStackImpl() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }

    @Override
    public void push(E newItem) {
        Node<E> newNode = new Node<>(newItem, top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E topItem = top.getItem();
        top = top.getNext();
        size--;
        return topItem;
    }
}
