package ch08_Sort;

public class ch0804_ShellSort {

    /*
    삽입정렬에 전처리 과정을 추가한 것
    각 단계마다 일정 간격으로 떨어진 원소들에 대해 삽입정렬을 수행
    간격 = 1일 때 삽입정렬과 동일
    */

    public void sort(int[] a) {
        int h = 4;
        while (h >= 1) {
            // h-정렬 수행
            for (int i = h; i < a.length; i++) { // (h,0) (h+1, 1) ... 이런식으로 진행
                for (int j = i; j >= h && a[j] < a[j - h]; j++) { // j = i인 것은 삽입정렬과 동일
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
