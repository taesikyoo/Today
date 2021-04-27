package ch04_Stack;

public interface ListStack<E> {

    E peek();

    void push(E newItem);

    E pop();

}
