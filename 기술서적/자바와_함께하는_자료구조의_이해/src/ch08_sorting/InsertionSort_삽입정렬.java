package src.ch08_sorting;

public class InsertionSort_삽입정렬 {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) { // i는 현재 원소의 인덱스
            for (int j = i; j > 0; j--) { // 현재 원소를 정렬된 앞부분에 삽입
                if (isless(a[j], a[j - 1]))
                    swap(a, j, j - 1);
                else break;
            }
        }
    }

    private static boolean isless(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
