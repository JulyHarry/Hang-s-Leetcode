public class ContainerWithMostWater {
    public static int maxArea(int[] height){
        int max = 0, i = 0, j = height.length - 1;
        if (height.length <= 1) return 0;
        while (i < j){
            int h = Math.min(height[j], height[i]);
            max = Math.max(max, (j - i) * h);
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return max;
    }

    public static int maxAreaBM(int[] height){
        // do by myself, but O(n) = n^2;
        int max = 0;
        if (height.length <= 1) return 0;
        for(int i = 0; i < height.length; i++){
            for(int j = height.length - 1; j > i; j--){
                int area = Math.min(height[i],height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
