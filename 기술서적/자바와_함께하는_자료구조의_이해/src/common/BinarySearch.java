package src.common;

public class BinarySearch {

    public static int binarySearch(int[] a, int left, int right, int t) {
        if (left > right) return -1;
        int mid = (left + right) / 2;

        if (a[mid] == t) return mid;
        else if (a[mid] > t) return binarySearch(a, left, mid - 1, t);
        else return binarySearch(a, mid + 1, right, t);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 8, 10, 15, 20, 25, 30, 40, 50, 55, 60, 70, 80, 85, 90}; // 데이터가 감소하지 않는 순서로 정렬되어 있음을 전제로 함
        System.out.println(binarySearch(a, 0, a.length - 1, 60)); // 10
    }
}
