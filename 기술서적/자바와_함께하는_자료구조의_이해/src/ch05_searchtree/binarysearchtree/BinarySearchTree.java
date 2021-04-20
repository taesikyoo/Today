package src.ch05_searchtree.binarysearchtree;

public interface BinarySearchTree<Key extends Comparable<Key>, Value> {

    void put(Key k, Value v);

    Key min();

    void deleteMin();

    void delete(Key k);

}
