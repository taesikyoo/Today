package ch08_Sort;

public class ch0802_SelectionSort {

    /*
    - 주어진 배열에서 순회를 할 때마다 최솟값 및 최댓값을 찾아서 배열의 앞쪽으로 정렬하
    - 최악의 경우는 버블 정렬과 동일하게 O(n2)의 시간 복잡도
    1. 배열에서 최솟값을 찾습니다.
    2. 1의 값을 배열의 맨 앞과 교체합니다. (swap)
    3. 교체한 자리를 제외하고 정렬할 개수가 1개만 남을 때까지 (1)부터 반복합니다.

    - 정렬 여부와 상관없이 항상 O(n^2)이다. => 입력에 민감하지 않다.
    - 횟솟값을 찾은 후 원소를 교환하는 횟수가 n-1번으로 가장 작은 최악경우 교환횟수이다.
    */

    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) { // 배열 길이만큼 순회
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) { // min의 다음 값부터 최솟값을 찾음
                if (a[minIndex] > a[j]) minIndex = j;
            }
            swap(a, minIndex, i); // 시작했던 인덱스와 최솟값의 인덱스의 값을 교환
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
