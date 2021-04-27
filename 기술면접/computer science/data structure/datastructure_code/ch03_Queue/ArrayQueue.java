package ch03_Queue;

public interface ArrayQueue<E> {

    void add(E newItem);

    E remove();

    void resize(int newSize);

}
