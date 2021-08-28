package BinarySearch;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/1/23
 */
public class MySqrt {
    public int mySqrt(int x) {
        long y = x;
        long left = 0;
        long right = y;
        long res = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == y) {
                return (int) mid;
            } else if (mid * mid > y) {
                right = mid - 1;
            } else if (mid * mid < y) {
                res = mid;
                left = mid + 1;
            }
        }
        return (int) res;
    }
}
