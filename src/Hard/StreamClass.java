package Hard;

import java.util.Arrays;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/3/22
 */
public class StreamClass {
    public void test(int[] nums) {
        String[] result = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        String s = Arrays.toString(result);
        System.out.println(s);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        StreamClass streamClass = new StreamClass();
        streamClass.test(nums);
    }
}
