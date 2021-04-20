package src.ch03_stack_queue;

public interface ArrayStack<E> {

    E peek();

    void push(E newItem);

    void resize(int newSize);

    E pop();

}
