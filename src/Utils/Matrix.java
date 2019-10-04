package Utils;

public class Matrix {
    public static <T> void show(T[][] matrix) {
        for (T[] row : matrix) {
            for (T col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }
    }

    public static void show(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }
    }

    public static void show(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }
    }

    public static void show(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            for (boolean col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }
    }
}
