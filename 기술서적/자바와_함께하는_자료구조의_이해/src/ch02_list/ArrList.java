package src.ch02_list;

public interface ArrList<E> {

    E peek(int k);

    void insertLast(E newItem);

    void insert(E newItem, int k);

    E delete(int k);

}
