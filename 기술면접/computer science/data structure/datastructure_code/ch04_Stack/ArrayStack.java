package ch04_Stack;

public interface ArrayStack<E> {

    E peek();

    void push(E newItem);

    void resize(int newSize);

    E pop();

}
