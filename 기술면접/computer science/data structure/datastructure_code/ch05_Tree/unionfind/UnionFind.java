package ch05_Tree.unionfind;

public class UnionFind {

    protected Node[] a;

    public UnionFind(Node[] iarray) {
        this.a = iarray;
    }

    // i가 속한 집합의 루트를 재귀적으로 찾고 경로상의 각 원소의 부모를 루트로 만든다
    protected int find(int i) {
        if (i != a[i].getParent())
            a[i].setParent(find(a[i].getParent()));
        return a[i].getParent();
    }

    public void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);
        if (iroot == jroot) return; // 루트노드가 동일하면 더 이상의 수행없이 그대로 리턴

        // rank가 높은 루트노드가 승자가 된다
        if (a[iroot].getRank() > a[jroot].getRank())
            a[jroot].setParent(iroot);
        else if (a[iroot].getRank() < a[jroot].getRank())
            a[iroot].setParent(jroot);
        else {
            a[jroot].setParent(iroot); // 둘 중에 하나를 임의로 승자로 지정
            int t = a[iroot].getRank() + 1;
            a[iroot].setRank(t); // iroot의 rank 1 증가
        }
    }
}
