public class SqrtX {
    public static int mySqrtM1(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, ans = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (mid * mid <= x){
                left = mid + 1;
                ans = mid;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int mySqrtM2(int x) {
        if (x == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true){
            int mid = left + (right - left)/ 2;
            if (mid > x / mid){
                right = mid - 1;
            }else {
                if (mid + 1 > x / (mid +1)) return mid;
                left = mid + 1;
            }
        }

    }

    public static int mySqrtNoWay(int x) {
        return x > 0 ? (int) Math.sqrt(x) : 0;
    }
}
