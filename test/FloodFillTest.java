import org.junit.jupiter.api.Test;

class FloodFillTest {

    @Test
    void floodFill() {
        FloodFill ff = new FloodFill();
        int[][] images = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int newColor = 2;
        int[][] arr = ff.floodFill(images, 1, 1, newColor);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}