import java.util.Arrays;

public class RemoveElements {
    public static int removeElement1(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int res = 0;
        for (int i=0, j=nums.length-1; i<=j;){
            if (nums[i]==val) {
                nums[i]=nums[j--];
            } else {
                i++;
            }
            res=j+1;
        }
        return res;
    }

    public static int removeElement3(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        while (i<=j) {
            if (nums[i]==val) {
                nums[i]=nums[j--];
            } else {
                i++;
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] n1 = {3,3,3,3,1};
        int[] n2 = {3,3,3,3,1};
        int[] n3 = {3,3,3,3,1};
        System.out.println(removeElement1(n1,3));
        System.out.println(removeElement2(n2,3));
        System.out.println(removeElement3(n3,3));
    }


}
