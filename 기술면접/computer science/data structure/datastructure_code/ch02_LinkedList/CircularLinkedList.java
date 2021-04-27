package ch02_LinkedList;

import src.common.Node;

public interface CircularLinkedList<E> {

    void insert(E newItem);

    Node delete();
}
