public class StringtoInteger {
    public static int myAtoi(String str){
        char[] c = str.toCharArray();
        int i = 0, sign = 1, total = 0;
        // 1. empty string
        if (str.length() == 0) return 0;

        // 2. space
        while (c[i] == ' ' && i < c.length) i++;

        // 3. sign
        if (c[i] == '-' || c[i] == '+') {
            sign = c[i++] == '-' ? -1 : 1;
        }

        // 4. overflow
        while (i < c.length){ // loop is initial.
            if(c[i] >= '0' && c[i] <= '9'){
                if(total > Integer.MAX_VALUE / 10 || total == Integer.MAX_VALUE / 10 && c[i] > '7'){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                total = total * 10 + c[i++] - '0'; // do not forget " c[i] - '0' ".
            }else break; // "break" is very important and shouldn't be "return 0".
        }
        return sign * total;
    }
}
