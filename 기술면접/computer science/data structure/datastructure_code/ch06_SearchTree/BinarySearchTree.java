package ch06_SearchTree;

public interface BinarySearchTree<Key extends Comparable<Key>, Value> {

    void put(Key k, Value v);

    Key min();

    void deleteMin();

    void delete(Key k);

}
