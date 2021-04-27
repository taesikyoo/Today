package ch03_Queue;

import java.util.NoSuchElementException;

public class ArrayQueueImpl<E> implements ArrayQueue<E> {

    private E[] q;
    private int front, rear, size; //front는 항상 비워놓는다, 큐가 비어있을 때 front = empty이다

    public ArrayQueueImpl() {
        q = (E[]) new Object[2]; // 사이즈가 2
        front = size = rear = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void add(E newItem) {
        if ((rear + 1) % q.length == front) // 비어 있는 원소가 1개뿐인 경우, 원형 큐라 생각하고 나머지 연산
            resize(2 * q.length);

        rear = (rear + 1) % q.length;
        q[rear] = newItem;
        size++;
    }

    @Override
    public E remove() {
        if (isEmpty()) throw new NoSuchElementException();

        front = (front + 1) % q.length;
        E item = q[front];
        q[front] = null;
        size--;

        if (size > 0 && size == q.length / 4) {
            resize(q.length / 2);
        }

        return item;
    }

    @Override
    public void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 1, j = front + 1; i < size + 1; i++, j++) { // i가 1부터 시작, front는 비워놓음
            t[i] = q[j % q.length];
        }

        front = 0;
        rear = size;
        q = (E[]) t;
    }
}
