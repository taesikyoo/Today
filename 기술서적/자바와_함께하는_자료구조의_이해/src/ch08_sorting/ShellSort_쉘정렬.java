package src.ch08_sorting;

public class ShellSort_쉘정렬 {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 4; // 3x+1 간격, 4와 1만을 사용
        while (h >= 1) {
            for (int i = h; i < N; i++) { // h-정렬 수행, 간격이 h인 원소들끼리 정렱
                for (int j = i; j >= h && isless(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
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
