public class Fibonacci {
    public static int fibonacci (int n) {
        if (n<0) return -1;
        if (n==0 || n==1) return n;
        int pre = 0;
        int cur = 1;
        int rtn = 0;
        for (int i = 2; i <= n; i++) {
            rtn = pre + cur;
            pre = cur;
            cur = rtn;
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }
}
