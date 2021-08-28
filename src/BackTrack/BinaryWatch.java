package BackTrack;

import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int n) {
        List<String> result = new LinkedList<>();
        int[] nums = {480, 240, 120, 60, 32, 16, 8, 4, 2, 1};
        LinkedList<Integer> track = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            track.add(i);
        }
        backtrack(n, 0, nums, result, track, 0);
        return result;
    }

    private void backtrack (int n, int cur, int[] nums, List<String> result, LinkedList<Integer> track, int level) {
        if (cur >= 720) {
            return;
        }
        if (n == level) {
            result.add(print(cur));
            return;
        }

        for (int i = 0; i < track.size(); i++) {
            int val = track.get(i);
            track.remove(i);
            cur += nums[i];
            backtrack(n, cur, nums, result, track, ++level);
            --level;
            cur -= nums[i];
            track.add(i, val);
        }
    }

    public String print(int time) {
        String hour = Integer.toString(time/60);
        String minute = Integer.toString(time % 60);
        if (minute.length() == 1) minute = "0" + minute;
        return hour + ":" + minute;
    }
}
