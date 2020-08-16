import java.util.ArrayList;
import java.util.List;

public class Paths {
    /*
    62 Unique Paths  https://leetcode-cn.com/problems/unique-paths/
    63 Unique Paths II    https://leetcode-cn.com/problems/unique-paths-ii/
     */
    public static int uniquepaths(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) path[i][0] = 1;
        for (int i = 0; i < n; i++) path[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n - 1];
    }

    public static int uniquepathsWithBlock(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        if (matrix[0][0] == 1) return 0;
        matrix[0][0] = 1;
        boolean flag = true;
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 1) flag = false;
            matrix[i][0] = flag ? 1 : 0;
        }
        flag = true;
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 1) flag = false;
            matrix[0][i] = flag ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }
        return matrix[m - 1][n - 1];
    }

    public static int minPathTotalInRectangle(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static int minPathTotalInRectangle2(int[][] grid) {
        // use 1d array
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j==0) {
                    dp[j] += grid[i][j];
                } else {
                    dp[j] += Math.min(dp[j], dp[j-1])+grid[i][j];
                }
            }
        }
        return dp[n-1];
    }

    public static int minPathTotalInRectangle3(int[][] grid) {
        // use 1d array
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0) {
                    dp[i] += grid[i][j];
                } else {
                    dp[i] += Math.min(dp[i], dp[i-1])+grid[i][j];
                }
            }
        }
        return dp[m-1];
    }

    public static int minPathTotalInTriangle(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i<n; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
            dp[i][i] = triangle.get(i).get(i) + dp[i-1][i-1];
        }
        for (int i=1; i<n; i++) {
            for (int j=1; j<i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1])+triangle.get(i).get(j);
            }
        }
        int min = dp[n-1][0];
        for (int i=1 ; i<n ;i++) {
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(uniquepaths(3, 7));
        int[][] matrix = {{0, 1}, {0, 0}};
        System.out.println(uniquepathsWithBlock(matrix));
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathTotalInRectangle(grid));
        int[][] grid2 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathTotalInRectangle2(grid2));
        int[][] grid3 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathTotalInRectangle3(grid3));
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        triangle.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);
        System.out.println(minPathTotalInTriangle(triangle));
    }
}
