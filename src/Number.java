import java.util.*;

public class Number {

    /*
    https://leetcode.com/problems/single-number/
     */
    public static int SingleNumber1 (int[] nums) {
        // Bit Manipulation
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

    public static int SingleNumber2 (int[] nums) {
        // HashMap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num) == null || map.get(num) == 0) {
                map.put(num, 1);
            } else {
                map.remove(num);
            }
        }
        return map.keySet().iterator().next();
    }

    public static int SingleNumber3 (int[] nums) {
        // List
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int num: nums) {
            if (list.contains(num)) {
                list.remove(list.indexOf(num));  // *List remove*
            } else {
                list.add(num);
            }
        }
        return list.iterator().next();
    }

    public static boolean HappyNumber(int n) {
        if (n == 1) {
            return true;
        } else {
            if (n > Integer.MAX_VALUE) return false;
            int sum = 0;
            while (n / 10 > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            sum += n * n;
            return HappyNumber(sum);
        }
    }

//    public static boolean isDigit (int n) {
//        if (n % 10 >= 0 && n % 10 < 10 && n / 10)
//    }


    public static void main(String[] args) {
//        int[] nums = {2,2,1};
//        System.out.println(SingleNumber1(nums));
//        System.out.println(SingleNumber2(nums));
//        System.out.println(SingleNumber3(nums));
        System.out.println(HappyNumber(2));
    }
}
