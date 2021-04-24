package Sort;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/2/21
 */
public class HeapSort {
    public void heapify(int[] arr, int i, int len) {
        if (i >= len) {
            return;
        }
        int j = 2 * i + 1;
        if (j < len && arr[i] < arr[j]) {
            if (j + 1 < len && arr[j] < arr[j + 1]) {
                j++;
            }
            swap(arr, i, j);
            heapify(arr, j, len);
        }
    }

    public void build_heap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public void sort(int[] arr) {
        build_heap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
