package Sort;

import java.util.Arrays;

/**
 * Description: 排序总结
 *
 * @author HarryUp
 * @date 2021/3/23
 */
public class Sort2103 {
    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[cur]) {
                    cur = j;
                }
            }
            swap(nums, i, cur);
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序（双向）
     *
     * @param nums
     */
    public void selectionSort2(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int max = i;
            int min = i;
            for (int j = i + 1; j < nums.length - i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min == max) {
                break;
            }
            swap(nums, i, min);
            if (max == i) {
                max = min;
            }
            swap(nums, nums.length - i - 1, max);
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    public void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public void quickSort(int[] nums) {

    }

    /**
     * 归并排序
     *
     * @param nums
     */
    public void mergeSort(int[] nums) {
        merge_sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void merge_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int m = left + (right - left) / 2;
        merge_sort(nums, left, m);
        merge_sort(nums, m + 1, right);
        merge(nums, left, m, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] l = new int[mid - left + 1];
        int[] r = new int[right - mid];
        int p = 0;
        int q = 0;
        int k = left;
        for (int i = left; i <= mid; i++) {
            l[p++] = nums[k++];
        }
        for (int i = mid + 1; i <= right; i++) {
            r[q++] = nums[k++];
        }
        p = 0;
        q = 0;
        k = left;
        while (p < l.length && q < r.length) {
            nums[k++] = l[p] <= r[q] ? l[p++] : r[q++];
        }
        while (p < l.length) {
            nums[k++] = l[p++];
        }
        while (q < r.length) {
            nums[k++] = r[q++];
        }
    }

    private void merge_sort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int m = left + (right - left) / 2;
        merge_sort(nums, left, m);
        merge_sort(nums, m + 1, right);

        // 与 merge_sort 的区别，影响了 merge2 部分代码，因为 mid 的两侧一定是已经排好序的两个部分
        // 如果 mid == m，则说明 l 应该包含 m ，即从 [left, mid]
        // 如果 mid == m + 1, 那么传入后 l 不应该包含 这个 m + 1， 即从 [left, mid)
        merge(nums, left, m + 1, right);
    }

    private void merge2(int[] nums, int left, int mid, int right) {
        int[] l = new int[mid - left];
        int[] r = new int[right - mid + 1];
        int p = 0;
        int q = 0;
        int k = left;
        for (int i = left; i < mid; i++) {
            l[p++] = nums[k++];
        }
        for (int i = mid; i <= right; i++) {
            r[q++] = nums[k++];
        }
        p = 0;
        q = 0;
        k = left;
        while (p < l.length && q < r.length) {
            nums[k++] = l[p] <= r[q] ? l[p++] : r[q++];
        }
        while (p < l.length) {
            nums[k++] = l[p++];
        }
        while (q < r.length) {
            nums[k++] = r[q++];
        }
    }

    /**
     * 堆排序
     *
     * @param nums
     */
    public void heapSort(int[] nums) {

    }

    /**
     * 希尔排序
     *
     * @param nums
     */
    public void shellSort(int[] nums) {

    }

    private void swap(int[] nums, int x, int y) {
        if (x == y) {
            return;
        }
        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[x] ^ nums[y];
        nums[x] = nums[x] ^ nums[y];
    }
}
