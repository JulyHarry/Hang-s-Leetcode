import Utils.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Intervals {
    /*
    1. MergeIntervals Leetcode-56: https://leetcode-cn.com/problems/merge-intervals/
    2. InsertInterval Leetcode-57: https://leetcode-cn.com/problems/insert-interval/
     */

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);

        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// a[0] - b[0]大于0就交换顺序
        // 根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // i不能到最后一行,所以要小于(数组的长度 - 1)
            // 判断所在行的right和下一行的left大小,对right重新进行赋最大值,之后再不断进行while循环判断
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
//        int[][] ans = new int[res.size()][];
//        for (int k=0; k<res.size(); k++) {
//            ans[k] = res.get(k);
//        }
//        return ans;
        return res.toArray(new int[0][]);
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int[][] arr = new int[intervals.length+1][];
        for (int i=0; i<intervals.length; i++) {
            arr[i] = intervals[i];
        }
        arr[arr.length-1] = newInterval;
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// a[0] - b[0]大于0就交换顺序
        // 根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < arr.length) {
            int left = arr[i][0];
            int right = arr[i][1];
            // i不能到最后一行,所以要小于(数组的长度 - 1)
            // 判断所在行的right和下一行的left大小,对right重新进行赋最大值,之后再不断进行while循环判断
            while (i < arr.length - 1 && right >= arr[i + 1][0]) {
                i++;
                right = Math.max(right, arr[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
//        int[][] ans = new int[res.size()][];
//        for (int k=0; k<res.size(); k++) {
//            ans[k] = res.get(k);
//        }
//        return ans;
        return res.toArray(new int[0][]);
    }


    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}, {3, 4}, {16, 18}, {17, 21}};Matrix.show(merge(intervals));
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{13,16}};
        int[] newInterval = {11,12};
        Matrix.show(insert(intervals, newInterval));
    }
}
