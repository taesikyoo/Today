package src.ch02_list;

import src.common.Node;

public interface CircularLinkedList<E> {

    void insert(E newItem);

    Node delete();
}
