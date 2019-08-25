import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static double medianOfTwoSortedArrays(int[] nums1,int[] nums2){
        double m = 0;
        int len = nums1.length + nums2.length;
        int[] merge = new int[len];
        merge = Arrays.copyOf(nums1,nums1.length);
        merge = Arrays.copyOfRange(nums2,0, nums2.length);
        for(int i : merge){
            System.out.println(i);
        }
        return m;
    }
}
