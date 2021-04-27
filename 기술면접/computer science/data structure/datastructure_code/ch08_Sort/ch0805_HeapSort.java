package ch08_Sort;

public class ch0805_HeapSort {

    /*
    배열에 저장된 value를 key값으로 해서 최대힙을 만든다
    이후 루트노드의 숫자를 힙의 가장 마지막 노드에 있는 숫자와 교환, 즉 마지막 노드가 가장 최댓값이 됨
    힙 크기를 1 감소시키고 루트노드로 이동한 숫자로 인해 위배된 힙속성을 downheap으로 복원한다
    힙 크기가 1이 되었을 때 정렬 종료

    힙 구성에 O(N) 시간
    downheap에 O(logN)시간 * (N-1)번 교환(루트와 힙을 교환)
    항상 O(NlogN) 수행시간이 소요
    대용략의 입력을 정렬하기에 부적절할 수도
    */

    public void sort(int[] a) {
        int heapSize = a.length - 1; // 0번째 인덱스는 사용하지 않음, 1부터 시작해서 자식은 2k, 2k+1이어야하므로

        for (int i = heapSize / 2; i > 0; i--) {
            downheap(a, i, heapSize);
        }

        while (heapSize > 1) {
            swap(a, 1, heapSize--); // 가장 큰 값을 가진 원소와 마지막 원소 교환 + 힙 사이즈 감소
            downheap(a, 1, heapSize);
        }
    }

    private void downheap(int[] a, int i, int heapSize) {
        while (2 * i <= heapSize) {
            int j = 2 * i; // j는 i의 왼쪽 자식
            if (j < heapSize && a[j] < a[j + 1]) j++; // 오른쪽 자식이 큰 경우
            if (a[i] > a[j]) break; // 힙속성을 만족하면 멈춤
            swap(a, i, j); // 힙속성을 만족하지 않으면 부모(i)와 자식 승자(j)를 교환
            i = j; // 부모 자리를 자식 승자 자리로 바꿈
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
