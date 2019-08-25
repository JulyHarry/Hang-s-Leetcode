import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
