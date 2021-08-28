package BinarySearch;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/1/24
 */
public class BinarySearchLeftRange {
    public int searchLeft1(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left >= nums.length) {
            return nums.length;
        }
        return left;
    }

    public int searchLeft2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right <= 0) {
            return 0;
        }
        return left;
    }
}