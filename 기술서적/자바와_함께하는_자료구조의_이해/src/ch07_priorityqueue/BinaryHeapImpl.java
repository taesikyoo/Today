package src.ch07_priorityqueue;

public class BinaryHeapImpl<Key extends Comparable<Key>, Value> implements BinaryHeap<Key, Value> {

    private Entry[] a; // a[0]은 사용 안함
    private int N; // 힙의 크기(=힙에 있는 항목 수)

    public BinaryHeapImpl(Entry[] harray, int initialSize) {
        this.a = harray;
        N = initialSize;
    }

    public int size() {
        return N;
    }

    private boolean greater(int i, int j) {
        return a[i].getKey().compareTo(a[j].getKey()) > 0;
    }

    private void swap(int i, int j) {
        Entry temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Override
    public void createHeap() {
        for (int i = N / 2; i > 0; i--) {
            downheap(i);
        }
    }

    private void downheap(int i) { // i는 현재 노드의 인덱스
        while (2 * i <= N) { // i의 왼쪽 자식노드가 힙에 있으면
            int k = 2 * i; // k는 왼쪽 자식노드의 인덱스
            if (k < N && greater(k, k + 1)) k++; // k가 승자의 인덱스가 됨
            if (!greater(i, k)) break; // 현재 노드가 자식 승자와 같거나 작으면 루프를 중단하고
            swap(i, k); // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자와 교환
            i = k; // 자식 승자가 현재 노드가 되어 다시 반복하기 위해
        }
    }

    @Override
    public void insert(Key newKey, Value newValue) { // 새로운 항목 삽입
        Entry temp = new Entry(newKey, newValue); // Entry 생성
        a[++N] = temp; // 새로운 키(항목)를 배열 마지막 항목 다음에 저장
        upheap(N); // 위로 올라가며 힙속성 회복
    }

    private void upheap(int j) { // j는 현재 노드의 인덱스
        while (j > 1 && greater(j / 2, j)) { // 현재 노드가 루트가 아니고 동시에 부모가 크면
            swap(j / 2, j); // 부모와 현재 노드 교환
            j = j / 2; // 부모가 현재 노드가 되어 다시 반복하기 위해
        }
    }

    @Override
    public Entry deleteMin() { // 최솟값 삭제
        Entry min = a[1]; // a[1]에 저장된 최솟값을 min에 저장
        swap(1, N--); // 힙의 마지막 항목과 교환 + 힙 크기 1 감소
        a[N+1] = null; // 마지막 항목을 null로 처리
        downheap(1); // 힙속성 회복
        return min;
    }

}
