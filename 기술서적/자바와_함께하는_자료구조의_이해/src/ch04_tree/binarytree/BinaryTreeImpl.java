package src.ch04_tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImpl implements BinaryTree {

    private Node root;

    public BinaryTreeImpl() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void preorder(Node n) { // 전위순회, 2 -> 1 -> 3
        if (n != null) {
            System.out.println(n.getKey() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    @Override
    public void inorder(Node n) { // 중위순회, 1 -> 2 -> 3
        if (n != null) {
            inorder(n.getLeft());
            System.out.println(n.getKey() + " ");
            inorder(n.getRight());
        }
    }

    @Override
    public void postorder(Node n) { // 후위순회, 1 -> 3 -> 2
        if (n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.println(n.getKey() + " ");
        }
    }

    @Override
    public void levelorder(Node n) {
        Queue<Node> q = new LinkedList<>();
        Node t;
        q.add(root);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.println(t.getKey() + " ");
            if (t.getLeft() != null)
                q.add(t.getLeft());
            if (t.getRight() != null)
                q.add(t.getRight());
        }
    }

    @Override
    public int size(Node n) { // n을 루트로 하는 (서브)트리에 있는 노드 수
        if (n == null)
            return 0;
        else
            return (1 + size(n.getLeft()) + size(n.getRight()));
    }

    @Override
    public int height(Node n) { // n을 루트로 하는 (서브)트리의 높이
        if (n == null)
            return 0;
        else
            return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
    }

    @Override
    public boolean isEqual(Node n, Node m) {
        if (n == null || m == null)
            return n == m;

        if (n.getKey().compareTo(m.getKey()) != 0) // 둘 다 null이 아니면 item 비교
            return false;

        return (isEqual(n.getLeft(), n.getRight()) &&
                isEqual(n.getRight(), m.getRight()));
    }

}
