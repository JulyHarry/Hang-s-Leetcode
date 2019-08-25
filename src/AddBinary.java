import java.lang.reflect.Array;
import java.util.Arrays;

public class AddBinary {
    public static String addBinary(String a, String b){
        /**
         * 基本的思路：
         * 1. 从每个String的末位开始相加
         * 2. 每个String单独循环
         * 3. 获取每个位置的数字可以通过 charAt(i) - '0' 或 Character.getNumericValue(); 实现
         * 4. 获得进位信息 和当前值
         * 5. 将输出序列反向输出
         *
         * 注意事项：
         * 不能转化成整数，因为整数型是有上限的
         * */
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0, carry = 0;
        while (i >= 0 || j >= 0){
            sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static String addBinaryFailure(String a, String b) {
        // 仍然转换成整数出错
        int len = Math.max(a.length(), b.length());
        int[] arr = new int[len + 1];
        int Ia = Integer.parseInt(a), Ib = Integer.parseInt(b);
        int sum = Ia + Ib;
        String convsum = Integer.toString(sum);
        for(int i = 0; i < len; i++){ // 从string转换成数字求和后转化成的数组
            arr[i + 1] = Character.getNumericValue(convsum.charAt(i));
        }
        for(int i = len; i > 0; i--){
            if(arr[i] == 2){
                arr[i] = 0;
                arr[i-1]++;
            }
        }
        StringBuilder convarr = new StringBuilder();
        for(int k : arr){
            convarr.append(k);
        }
        String convstr = convarr.toString();
        return arr[0] == 0 ? convstr.substring(1): convstr;
    }
}
