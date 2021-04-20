package src.ch03_stack_queue;

import java.util.EmptyStackException;

public class ArrayStackImpl<E> implements ArrayStack<E> {

    private E s[];
    private int top;

    public ArrayStackImpl() {
        s = (E[]) new Object[1];
        top = -1;
    }

    public int size() {
        return top + 1; // size는 top+1임에 유의
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyStackException(); // empty stack exception이 존재
        return s[top];
    }

    @Override
    public void push(E newItem) {
        if (size() == s.length)
            resize(2 * s.length);
        s[++top] = newItem;
    }

    @Override
    public void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 0; i < size(); i++) {
            t[i] = s[i];
        }
        s = (E[]) t;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E item = s[top];
        s[top--] = null;
        if (size() > 0 && size() == s.length / 4)
            resize(s.length / 2);
        return item;
    }

}
