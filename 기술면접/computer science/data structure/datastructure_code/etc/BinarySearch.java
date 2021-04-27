package etc;

public class BinarySearch {

    public int binarySearchRecursive(int[] a, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (a[mid] == target) return mid;
        else if (a[mid] < target) return binarySearchRecursive(a, mid + 1, right, target);
        else return binarySearchRecursive(a, left, mid - 1, target);
    }

    public int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int mid;

        while (right >= left) {
            mid = (left + right) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
