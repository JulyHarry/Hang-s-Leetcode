package TEST;

import java.util.Arrays;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/16
 */
public class testlamada {
    public static void main(String[] args) {
//        int[][] nums = {{4, 3, 21, 34}};
//        Arrays.sort(nums, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        String a = "is2 sentence4 This1 a3";
        String[] nums1 = a.split(" ");
        Arrays.sort(nums1,(o1, o2) -> {
            return o1.charAt(o1.length() - 1) - o2.charAt(o2.length() - 1);});
        String m = Arrays.toString(nums1);
        System.out.println("m = " + m);
        int[] n = {8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (int i : n) {
            System.out.println("i & (-i) = " + (i & (-i)));
        }
    }
}
