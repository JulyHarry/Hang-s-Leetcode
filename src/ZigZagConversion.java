public class ZigZagConversion {
    public static String convert(String s, int numRows){
        char[] c = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder();
        }
        int index = 0;
        while (index < s.length()){
            for (int Row = 0; Row < numRows && index < s.length(); Row++){
                sb[Row].append(c[index++]);
            }
            for (int Row = numRows - 2; Row >= 1 && index < s.length(); Row--){
                sb[Row].append(c[index++]);
            }
        }
        for (int i = 1; i < sb.length; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
