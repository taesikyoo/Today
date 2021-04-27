package ch02_LinkedList;

import static src.ch02_list.DoublyLinkedListImpl.DNode;

public interface DoublyLinkedList<E> {

    void insertBefore(DNode p, E newItem);

    void insertAfter(DNode p, E newItem);

    void delete(DNode x);

}
