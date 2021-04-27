package ch07_Heap;

public class MinHeapTree {

    private int[] heap;
    private int size; // tree의 사이즈를 의미
    private int pointer; // insert를 돕기 위한 포인터

    MinHeapTree(int size) {
        this.size = size;
        this.heap = new int[size + 1];
        // 자식 노드를 구하는 연산을 단순화시키기 위해서 0번지는 비워둔다.
        this.heap[0] = -1;
        this.pointer = 0;
    }

    /**
     * 최솟값 가져오기
     */
    public int getRoot() {
        return heap[1];
    }

    /**
     * 부모의 인덱스 가져오기
     *
     * @param index
     * @return
     */
    public int getParentIndex(int index) {
        // 인덱스가 1보다 작은 경우는 계산을 하지 않는다.
        if (index < 1) {
            return -1;
        }
        return index / 2;
    }

    /**
     * 왼쪽 자식의 인덱스 가져오기
     *
     * @param index
     * @return
     */
    public int getLeftChildIndex(int index) {
        // 인덱스가 1보다 작은 경우는 계산을 하지 않는다.
        if (index < 1) {
            return -1;
        }
        return 2 * index;
    }

    /**
     * 오른쪽 자식의 인덱스 가져오기
     *
     * @param index
     * @return
     */
    public int getRightChildIndex(int index) {
        // 인덱스가 1보다 작은 경우는 계산을 하지 않는다.
        if (index < 1) {
            return -1;
        }
        return (2 * index) + 1;
    }

    /**
     * 리프 노드 판별하기
     *
     * @param index
     * @return
     */
    public boolean isLeafNode(int index) {
        return getLeftChildIndex(index) > size && getRightChildIndex(index) > size;
        // 만약 리프 노드이면 자식 노드가 없으므로 자식 노드의 인덱스는 힙 트리 배열의 크기보다 큰 값을 가지게 됨
    }

    /**
     * 스왑 메서드
     *
     * @param cureentIndex
     * @param parentIndex
     */
    public void swap(int cureentIndex, int parentIndex) {
        int temp;
        temp = heap[cureentIndex];
        heap[cureentIndex] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    /**
     * 최소 힙 트리의 삽입
     *
     * @param value
     */
    public void insert(int value) {
        heap[++pointer] = value;
        int currentIndex = pointer;
        while (heap[currentIndex] < heap[getParentIndex(currentIndex)]) {
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    /**
     * 최솟값을 반환하면서 삭제
     *
     * @return
     */
    public int delete() {
        int result = getRoot();
        // 마지막 노드를 루트로 이동
        heap[1] = heap[size];
        heap[size] = -1;
        size--;
        if (size > 1) {
            rebuild(1);
        }
        return result;
    }

    /**
     * current index 인자 기준으로 heap 재구성
     *
     * @param current
     */
    private void rebuild(int current) {
        // current index 기준으로 왼쪽 자식과 오른쪽 자식 중 작은 값을 구한다.

        int leftChildIndex = getLeftChildIndex(current);
        int rightChildIndex = getRightChildIndex(current);
        if (isLeafNode(current)) {
            return;
        }

        int swapIndex = current;
        // 왼쪽 자식만 존재하는 경우
        if (rightChildIndex > size) {
            if (heap[leftChildIndex] < heap[current]) {
                swapIndex = leftChildIndex;
            }
        // 양쪽 자식 모두 존재하는 경우
        } else {
            // current index 기준으로 왼쪽 자식과 오른쪽 자식 중 작은 값을 구한다.
            if (heap[leftChildIndex] <= heap[rightChildIndex]) {
                swapIndex = leftChildIndex;
            } else {
                swapIndex = rightChildIndex;
            }
        }

        // current가 swap값보다 크면 자리를 바꾼다.
        if (heap[current] > heap[swapIndex]) {
            swap(current, swapIndex);
            rebuild(swapIndex);
        }
    }
}
