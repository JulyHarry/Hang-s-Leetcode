import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public static int distributeCandies (int[] arrs) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<arrs.length; i++) {
            set.add(arrs[i]);
        }
        return set.size()>arrs.length/2?arrs.length/2:set.size();
    }

    public static int distributeCandies2 (int[] candies) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int candy : candies) {
                if (candy > max) {
                    max = candy;
                }
                if (candy < min) {
                    min = candy;
                }
            }
            boolean[] arrs = new boolean[max - min + 1];//默认false
            int kind = 0;
            for (int candy : candies) {
                if (!arrs[candy - min]) {//没有遇到过
                    kind++;
                    arrs[candy - min] = true;//改为已经遇到过
                }
            }
            return kind >= candies.length / 2 ? candies.length / 2 : kind;
    }

    public static void main(String[] args) {
        int[] arrs = {1,1,2,3,2,3};
        System.out.println(distributeCandies(arrs));
        System.out.println(distributeCandies2(arrs));
    }

}