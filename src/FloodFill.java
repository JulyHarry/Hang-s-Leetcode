public class FloodFill {
    /*
     * Description: 733. Flood Fill
     * https://leetcode.com/problems/flood-fill/
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int orgColor = image[sr][sc];
        fill(image, sr, sc, orgColor, newColor);
        return image;
    }

    private void fill(int[][] image, int i, int j, int orgColor, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != orgColor) return;
        image[i][j] = newColor;
        fill(image, i + 1, j, orgColor, newColor);
        fill(image, i - 1, j, orgColor, newColor);
        fill(image, i, j + 1, orgColor, newColor);
        fill(image, i, j - 1, orgColor, newColor);
    }
}
