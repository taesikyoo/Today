package ch08_Sort;

public class ch0807_QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        if (high < low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1); // 피벗보다 작은 부분을 재귀호출
        sort(a, j + 1, high); // 피벗보다 큰 부분을 재귀호출
    }

    private static int partition(int[] a, int pivot, int high) {
        int i = pivot;
        int j = high + 1;
        int p = a[pivot];
        while (true) {
            while (a[++i] < p) if (i == high) break; // 피벗 값보다 작다면 계속 i를 ++
            while (p < a[--j]) if (j == pivot) break; // 피벗 겂보다 크다면 계속 j를 --
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, pivot, j); // 피벗과 a[j] 교환
        return j; // a[j]의 피벗이 "영원히" 자리 잡은 곳
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
