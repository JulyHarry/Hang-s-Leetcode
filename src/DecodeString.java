import java.util.Stack;

public class DecodeString {
    public static String decodeStringA1(String s) {
        // use two Stack
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))){
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) { // to input the Integer, and keep it.
                    count = 10*count + s.charAt(idx++) - '0';
                }
                countStack.push(count);
            }else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop()); // 初始化
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }else {
                res += s.charAt(idx++); // 不用在下一步再写idx++， 在这步写就可以
            }
        }
        return res;
    }

    public static String decodeStringA2(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 0) return s;
        int idx = 0;
        int count = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + s.charAt(idx++) - '0';
                }
                if (s.charAt(idx) == '[') {
                    int begin = ++idx;
                    int judge = 1;
                    while (judge != 0) {
                        if (s.charAt(idx) == '[') judge++;
                        if (s.charAt(idx) == ']') judge--;
                        idx++;
                    }
                    idx--;
                    String str = decodeStringA2(s.substring(begin, idx));
                    for (int i = 0; i < count; i++) {
                        sb.append(str);
                    }
                    count = 0;
                }
            }else if (s.charAt(idx) == ']'){
                idx++;
            }else {
                sb.append(s.charAt(idx));
                idx++;
            }
        }
        return sb.toString();
    }
}