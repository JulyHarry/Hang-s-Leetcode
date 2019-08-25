package Sort;

public class QuickSort {
    public static int[] quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int division = partition(arr, low, high);
            quicksort(arr, low, division-1);
            quicksort(arr, division+1, high);
        }
        return arr;
    }

    public static int partition(int[] arr, int low, int high) {
        int base = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= base) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= base) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}