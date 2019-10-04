import Utils.Matrix;

public class RotateMatrix90 {
    public static void rotateMatrix90_Copy(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) return;
        if (len != matrix[0].length) return;
        int[][] copy = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                copy[i][j] = matrix[j][i];
            }
        }
    }

    public static void rotateMatrix90(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) return;
        if (len != matrix[0].length) return;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }

    public static void rotateMatrix90_Loop(int[][] matrix) {
        int n = matrix.length;
        for (int loop = 0; loop < n / 2; loop++)                    //外层循环：处理 n/2 层
            for (int i = loop, j = loop; i < n - 1 - loop; i++) {   //中层循环：处理 n-1-loop次替换循环
                int pre = matrix[i][j];
                for (int time = 1; time <= 4; time++) {             //内层循环：处理 4 次替换过程
                    int tmpi = i;
                    i = j;
                    j = n - 1 - tmpi;
                    int temp = pre;
                    pre = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        Matrix.show(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix90(matrix1);
        rotateMatrix90_Loop(matrix2);
    }
}
