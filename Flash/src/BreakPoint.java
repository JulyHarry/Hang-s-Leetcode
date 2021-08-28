public class BreakPoint {
    public int sum (int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        BreakPoint breakPoint = new BreakPoint();
        int a = breakPoint.sum(3);
        int b = breakPoint.sum(7);
        int c = breakPoint.sum(11);
        int d = a + b + c;
        System.out.println("d = " + d);
    }
}
