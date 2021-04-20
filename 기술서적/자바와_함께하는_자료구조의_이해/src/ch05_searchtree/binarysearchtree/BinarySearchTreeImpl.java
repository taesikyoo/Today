package src.ch05_searchtree.binarysearchtree;

public class BinarySearchTreeImpl<Key extends Comparable<Key>, Value> implements BinarySearchTree<Key, Value> {

    public Node root;

    public BinarySearchTreeImpl(Key newId, Value newName) {
        root = new Node(newId, newName);
    }

    public Node getRoot() {
        return root;
    }

    public Value get(Key k) {
        return get(root, k);
    }

    public Value get(Node n, Key k) {
        if (n == null) return null; // k를 발견하지 못함

        int t = n.getKey().compareTo(k);
        if (t > 0) return get(n.getLeft(), k);
        else if (t < 0) return get(n.getRight(), k);
        else return (Value) n.getValue();
    }

    @Override
    public void put(Key k, Value v) {
        root = put(root, k, v);
    }

    public Node put(Node n, Key k, Value v) {
        if (n == null) return new Node(k, v);

        int t = n.getKey().compareTo(k);
        if (t > 0) n.setLeft(put(n.getLeft(), k, v));
        else if (t < 0) n.setRight(put(n.getRight(), k, v));
        else n.setValue(v);

        return n;
    }

    @Override
    public Key min() {
        if (root == null) return null;
        return (Key) min(root).getKey();
    }

    public Node min(Node n) {
        if (n.getLeft() == null) return n;
        return min(n.getLeft());
    }

    @Override
    public void deleteMin() {
        if (root == null) System.out.println("empty 트리");
        root = deleteMin(root);
    }

    public Node deleteMin(Node n) {
        if (n.getLeft() == null) return n.getRight();
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    @Override
    public void delete(Key k) {
        root = delete(root, k);
    }

    public Node delete(Node n, Key k) {
        if (n == null) return null;

        int t = n.getKey().compareTo(k);
        if (t > 0) n.setLeft(delete(n.getLeft(), k)); // 왼쪽 자식으로 이동
        else if (t < 0) n.setRight(delete(n.getRight(), k)); // 오른쪽 자식으로 이동
        else { // 삭제할 노드를 발견
            if (n.getRight() == null) return n.getLeft(); // 리프노드이거나 한쪽 자식 노드만 가지고 있을 때
            if (n.getLeft() == null) return n.getRight(); // 한쪽 자식 노드만 가지고 있을 때
            // 두쪽 모두 자식노드를 가지고 있을 때
            Node target = n;
            n = min(target.getRight()); // 삭제할 노드 자리로 옮겨올 노드를 찾아서 n이 가리키게 함
            n.setRight(deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
        }

        return n;
    }
}
