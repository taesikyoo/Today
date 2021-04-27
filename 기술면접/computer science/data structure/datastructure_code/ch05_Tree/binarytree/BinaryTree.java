package ch05_Tree.binarytree;

public interface BinaryTree {

    void preorder(Node n);

    void inorder(Node n);

    void postorder(Node n);

    void levelorder(Node n);

    int size(Node n);

    int height(Node n);

    boolean isEqual(Node n, Node m);

}
