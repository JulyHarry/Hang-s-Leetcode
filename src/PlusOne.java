public class PlusOne {
    public static int[] plusOneEasy(int[] digits){
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits; // 精妙之处
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1; // 后面自然是0
        return newNumber;
    }

    public static int[] plusOne(int[] digits) {
        // created by Hang although it is complex.
        int len = digits.length;
        int[] newdigits = new int[len + 1];
        digits[len - 1] ++;
        for (int i = digits.length - 1; i >= 1; i--){
            if(digits[i] >= 10){
                digits[i] -= 10;
                digits[i-1] =  digits[i-1] + 1;
            }
        }
        if(digits[0] >= 10){
            digits[0] -= 10;
            newdigits[0] = 1;
            for(int i = 0; i < len; i++){
                newdigits[i+1] = digits[i];
            }
            return newdigits;
        }
        return digits;
    }

    public static int[] plusOneFailure(int[] digits) {
        //如果超出整数的最大值，则无法表示
        StringBuilder rep = new StringBuilder();
        for (int digit : digits) {
            rep.append(digit);
        }
        String Sttmp = rep.toString();
        int Intmp = Integer.parseInt(Sttmp) + 1;
        String convert = Integer.toString(Intmp);
        int[] newarray = new int[convert.length()];
        for (int i = 0; i < convert.length(); i++){
            newarray[i] = Character.getNumericValue(convert.charAt(i));
        }
        return newarray;
    }
}
