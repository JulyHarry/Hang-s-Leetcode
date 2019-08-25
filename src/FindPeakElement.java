public class FindPeakElement {
    public int findPeakElement(int[] nums){
        if (nums.length == 1) return 0;
        int start = 0, end = nums.length - 1;
        while (start < end-1){
            int mid = (start + end)/2;
            if (nums[mid] < nums[mid+1]) {
                start = mid;
            }else if (nums[mid] < nums[mid-1]) {
                end = mid;
            }else {
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return end;
        }else return start;
    }

    public int findPeakElementA2(int[] nums) {
        // this is not recommended
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) {
            return 0;
        }else if (nums[n-2] < nums[n-1]) {
            return n-1;
        }else {
            int i = 1;
            while (i < n-1) {
                if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
                i++;
            }
        }
        return n;
    }
}
