import java.util.HashMap;
import java.util.Map;

public class FindTheTownJudge {
    public static int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] t : trust) {
            map.put(t[1], map.getOrDefault(t[1], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == N - 1) return entry.getKey();
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int [][] trust = {{1, 2}, {1, 3}, {4, 2}, {4, 3}, {5, 2}};
//        int N = 5;
//        System.out.println(findJudge(N, trust));
//    }
}
