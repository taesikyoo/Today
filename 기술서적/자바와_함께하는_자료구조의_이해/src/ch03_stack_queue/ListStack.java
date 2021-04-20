package src.ch03_stack_queue;

public interface ListStack<E> {

    E peek();

    void push(E newItem);

    E pop();

}
