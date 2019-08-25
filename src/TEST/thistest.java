package TEST;

public class thistest {
    int a = 10;
    public int test (int b) {
        this.a = b;
        return this.a;
    }
    int use () {
        return this.test(10);
    }
}
