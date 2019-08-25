public class IntegertoRoman {

    private static int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRomanM1(int num) {
        StringBuilder res = new StringBuilder();
        for (int i  = 0 ; i<nums.length; i++) {
            while (num >= nums[i]) {
                res.append(strings[i]);
                num -= nums[i];
            }
        }

        return res.toString();
    }

    public static String intToRomanM2(int num){
        String res = "";
        char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int value[] = {1000, 500, 100, 50, 10, 5, 1};

        for (int n = 0; n < 7; n += 2) {
            int x = num / value[n];
            if (x < 4) {
                for (int i = 1; i <= x; ++i) res += roman[n];
            } else if (x == 4) res = res + roman[n] + roman[n - 1];
            else if (x > 4 && x < 9) {
                res += roman[n - 1];
                for (int i = 6; i <= x; ++i) res += roman[n];
            }
            else if (x == 9) res = res + roman[n] + roman[n - 2];
            num %= value[n];
        }
        return res;
    }

    public static String intToRomanM3(int n){
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[n/1000] + C[(n%1000)/100]+ X[(n%1000)%100/10] + I[(n%1000)%100%10];
    }

    public static int romanToInt(String s){
        // test for RomantoInt and success!
        char[] c = s.toCharArray();
        int[] i = new int[c.length];
        for (int j = 0; j < c.length; j++){
            switch (c[j]){
                case 'I':
                    i[j] = 1;
                    break;
                case 'V':
                    i[j] = 5;
                    break;
                case 'X':
                    i[j] = 10;
                    break;
                case 'L':
                    i[j] = 50;
                    break;
                case 'C':
                    i[j] = 100;
                    break;
                case 'D':
                    i[j] = 500;
                    break;
                case 'M':
                    i[j] = 1000;
                    break;
            }
        }
        if (i.length == 0) return 0;
        if (i.length == 1) return i[0];
        int sum = 0;
        for (int j = 0; j < i.length - 1; j++){
            sum += i[j] < i[j + 1] ? -i[j] : i[j];
        }
        return sum + i[i.length - 1];
    }
}
