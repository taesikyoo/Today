package src.ch07_priorityqueue;

public interface BinaryHeap<Key extends Comparable<Key>, Value> {

    void createHeap();

    void insert(Key newKey, Value newValue);

    Entry deleteMin();

}
