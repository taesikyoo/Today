package ch08_Sort;

public class ch0803_InsertionSort {

    /*
    배열을 정렬된 부분과 정렬되지 않은 부분으로 나눔
    정렬되지 않은 부분의 가장 왼쪽 원소를 정렬된 부분에 삽입

    입력에 민감, 입력이 정렬된 경우 n-1번만 비교(O(n)), 역으로 정렬되어 있다면 O(n^2)

    뒷부분에 소량의 신규 데이터를 추가하는 경우
    입력크기가 작은 경우 (재귀호출을 하지 않아서 유리)
    */

    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) { // i는 현재 원소의 인덱스
            for (int j = i; j > 0; j--) { // 현재 원소를 정렬된 앞부분에 삽입
                if (a[j] < a[j - 1])
                    swap(a, j, j - 1);
                else break; // a[j] > a[j-1]이면 이미 j까지 정렬이 되어 있는 것이니 더 이상 작업 X
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
