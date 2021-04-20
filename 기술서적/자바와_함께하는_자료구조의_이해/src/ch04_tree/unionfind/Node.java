package src.ch04_tree.unionfind;

public class Node {

    int parent;
    int rank;

    public Node(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
