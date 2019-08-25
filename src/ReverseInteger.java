public class ReverseInteger{
    public static int reverse(int x)
    {
        int result = 0;
        while (x != 0){
            if (result > Integer.MAX_VALUE / 10) return  1;
            result = x % 10 + result * 10;
            x /= 10;
        }
        return result;
    }
}