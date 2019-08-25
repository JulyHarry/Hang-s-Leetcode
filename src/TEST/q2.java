//package TEST;
//
//
//import java.io.*;
//import java.util.*;
//public class q2 {
//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        int a;
//        a = cin.nextInt();
//        int[] b = new int[a];
//        int[] c = new int[a];
//        int cur = 1;
//        int sum = 0;
//        for (int i = 0; i < a; i++) {
//            b[i] = cin.nextInt();
//        }
//        for (int i = 0; i < a - 1; i++) {
//            if (b[i] > b[i + 1]) {
//                c[i] = cur++;
//                cur = 1;
//                continue;
//            }
//            c[i] = cur++;
//        }
//        if (b[a - 2] > b[a - 1]) {
//            cur = 1;
//        }
//        c[a - 1] = cur++;
//        int n = 1;
//        for (int i = 0; i < a; i++) {
//            if (i == a - 1 && c[i] == c[i - 1]) {
//                sum += n * (n - 1) / 2;
//                sum += c[i];
//                break;
//            }
//            if (i<a-1 && c[i] == c[i + 1]) {
//                n++;
//            } else {
//                sum += n * (n - 1) / 2;
//                n = 1;
//            }
//            sum += c[i];
//            }
//            System.out.print(sum);
//        }
//    }
//// 10 60 76 66 76 85 55 61 71 84 62
//// 9 80 30 20 60 90 50 40 30 20