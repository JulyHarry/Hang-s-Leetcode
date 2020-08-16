class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int low = matrix[0][0], high = matrix[n-1][n-1]+1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            int cnt = 0;
            int j = 0;
            int i = n - 1;
            while (i >= 0 && j < n) {
                if (matrix[i][j] > mid) {
                    i--;
                } else {
                    cnt += i+1;
                    j++;
                }
            }
            if (cnt >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,32,33},{4,42,46},{43,49,80}};
        int k = 4;
        System.out.println(new kthSmallest().kthSmallest(matrix, k));
    }
}
