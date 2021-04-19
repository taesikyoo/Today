package src.ch02_list;

import static src.ch02_list.DoublyLinkedListImpl.*;

public interface DoublyLinkedList<E> {

    void insertBefore(DNode p, E newItem);

    void insertAfter(DNode p, E newItem);

    void delete(DNode x);

}
