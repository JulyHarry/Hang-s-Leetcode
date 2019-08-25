//package TEST;
//
//import java.util.Scanner;
///**
// *
// * @author 二哈大叔
// *
// */
//public class Poker24 {
//    private static int COUNT = 4; //抽取的扑克牌数量
//    private static double[] number = new double[COUNT]; //扑克牌的数组
//    private static String[] expression = new String[COUNT]; //表达式数组
//
//    public static boolean checkCondition(int n, int m) {
//        //当递归到只有一个数时，判断是否满足条件
//        if (n == 1) {
//            if (number[0] == m) {
//                System.out.println(expression[0].substring(1, expression[0].length() - 1));
//                return true;
//            } else
//                return false;
//        }
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                double tempA = number[i];
//                double tempB = number[j];
//                String expreA = expression[i];
//                String expreB = expression[j];
//                number[j] = number[n - 1];
//                expression[j] = expression[n - 1];
//                //开始做加法
//                expression[i] = "(" + expreA + "+" + expreB + ")";
//                number[i] = tempA + tempB;
//                if (checkCondition(n - 1, m))
//                    return true;
//                //减法，两种情况，tempA-tempB和tempB-tempA
//                expression[i] = "(" + expreA + "-" + expreB + ")";
//                number[i] = tempA - tempB;
//                if (checkCondition(n - 1, m))
//                    return true;
//                expression[i] = "(" + expreB + "-" + expreA + ")";
//                number[i] = tempB - tempA;
//                if (checkCondition(n - 1, m))
//                    return true;
//                //乘法
//                expression[i] = "(" + expreA + "*" + expreB + ")";
//                number[i] = tempA * tempB;
//                if (checkCondition(n - 1, m))
//                    return true;
//                //除法，两种情况，tempA/tempB和tempB/tempA,并且保证分母不为0
//                if (tempB != 0) {
//                    expression[i] = "(" + expreA + "/" + expreB + ")";
//                    number[i] = tempA / tempB;
//                    if (checkCondition(n - 1, m))
//                        return true;
//                }
//                if (tempA != 0) {
//                    expression[i] = "(" + expreB + "/" + expreA + ")";
//                    number[i] = tempB / tempA;
//                    if (checkCondition(n - 1, m))
//                        return true;
//                }
//                number[i] = tempA;
//                number[j] = tempB;
//                expression[i] = expreA;
//                expression[j] = expreB;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        for (int i = 0; i < COUNT; i++) {
//            number[i] = scanner.nextInt();
//            int x;
//            x = (int) number[i];
//            expression[i] = String.valueOf(x);
//        }
//        if (checkCondition(COUNT, m))
//            System.out.println(1);
//        else
//            System.out.println(0);
//    }
//}