package src.ch02_list;

import src.common.Node;

public interface SinglyLinkedList<E> {

    int search(E target);

    void insertFront(E newItem);

    void insertLast(E newItem, Node p);

    void deleteFront();

    void deleteAfter(Node p);

}
