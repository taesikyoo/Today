package src.ch03_stack_queue;

public interface ArrayQueue<E> {

    void add(E newItem);

    E remove();

    void resize(int newSize);

}
