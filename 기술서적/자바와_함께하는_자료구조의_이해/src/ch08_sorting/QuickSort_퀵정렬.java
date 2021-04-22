package src.ch08_sorting;

public class QuickSort_퀵정렬<T extends Comparable<T>> {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high < low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1); // 피벗보다 작은 부분을 재귀호출
        sort(a, j + 1, high); // 피벗보다 큰 부분을 재귀호출
    }

    private static int partition(Comparable[] a, int pivot, int high) {
        int i = pivot;
        int j = high + 1;
        Comparable p = a[pivot];
        while (true) {
            while (isless(a[++i], p)) if (i == high) break; // 피벗보다 작으면
            while (isless(p, a[--j])) if (j == pivot) break; // 피벗보다 크면
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, pivot, j); // 피벗과 a[j] 교환
        return j; // a[j]의 피벗이 "영원히" 자리 잡은 곳
    }

    private static boolean isless(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
