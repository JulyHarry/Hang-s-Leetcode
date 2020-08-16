package contest;

public class c04 {
    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + exchange(numBottles, numExchange);
    }

    private int exchange (int numBottles, int numExchange) {
        if (numBottles < numExchange) return 0;
        int res = numBottles / numExchange;
        int left = numBottles % numExchange;
        char[] a = new char[2];
        a.toString();
        return res + numWaterBottles(res + left, numExchange);
    }

    public static void main(String[] args) {
        c04 c = new c04();
        int i = c.numWaterBottles(5,5);
        System.out.println(i);
    }
}
