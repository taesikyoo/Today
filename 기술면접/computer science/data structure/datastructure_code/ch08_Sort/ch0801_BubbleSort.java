package ch08_Sort;

public class ch0801_BubbleSort {

    /*
    - 인접한 두 요소의 값을 비교하여 대소관계에 따라 서로 자리를 교체
    - 최악의 경우 [1, 2, 3, 4, 5]의 배열을 역순으로 정렬하면 모든 요소의 자리를 교체해 주기 때문에 O(n2)의 시간복잡도
    - 속도가 매우 느린 정렬 알고리즘이지만 구현이 간단하여 데이터가 적은 곳에서 사용이 용이, 반대로 대규모 데이터에는 부적합
    */

    public int[] sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
            }
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
