package Math;

public class CheckStraightLine {
    // 注意： 能用乘法就不用除法，而且乘法效率要比除法高
    public boolean checkStraightLine(int[][] coordinates) {
        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];
        double x2 = coordinates[1][0];
        double y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            if((coordinates[i][0] - x1) * (coordinates[i][1] - y2) != (coordinates[i][0] - x2) * (coordinates[i][1] - y1)) return false;
        }
        return true;
    }

    public boolean checkStraightLine2(int[][] coordinates) {
        double x_base = coordinates[0][0];
        double y_base = coordinates[0][1];
        double det_x = coordinates[1][0] - x_base;
        double det_y = coordinates[1][1] - y_base;
        double k = 0;
        if (det_x != 0) {
            k = det_y/det_x;
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] - x_base == 0) return false;
                if ((coordinates[i][1]-y_base)/(coordinates[i][0]-x_base)!=k) return false;
            }
        } else {
            for (int i = 2; i < coordinates.length; i++) {
                if(coordinates[i][0]!=x_base) return false;
            }
        }
        return true;
    }
}
