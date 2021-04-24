package Sort;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/2/21
 */
public class MergeSort {
    public void merge(int[] arr, int l, int m, int r) {
        int p = 0, q = 0, k = l;
        int[] left = new int[m - l];
        int[] right = new int[r - m + 1];
        for (int i = l; i <= r; i++) {
            if (i < m) {
                left[p++] = arr[i];
            } else {
                right[q++] = arr[i];
            }
        }
        p = 0;
        q = 0;
        while (p < left.length && q < right.length) {
            arr[k++] = left[p] <= right[q] ? left[p++] : right[q++];
        }
        while (p < left.length) {
            arr[k++] = left[p++];
        }
        while (q < right.length) {
            arr[k++] = right[q++];
        }
    }

    public void mergesort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergesort(arr, l, m);
        mergesort(arr, m + 1, r);
        merge(arr, l, m + 1, r);
    }

    public void sort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }
}
