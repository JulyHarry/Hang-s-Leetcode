//package Leetcode;
//
//import java.util.HashMap;
//import java.util.Stack;
//
//public class NumberOfAtoms {
//    public String countOfAtoms(String f) {
//        HashMap<String,Integer> map = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        int idx = 0;
//        String name = "";
//        Stack<String> sym = new Stack<>();
//        Stack<Integer> cnt = new Stack<>();
//        while (idx < f.length()) {
//            if (Character.isUpperCase(f.charAt(idx))) {
//                name += f.charAt(idx);
//                idx++;
//                if (Character.isLowerCase(f.charAt(idx))) {
//                    name += f.charAt(idx);
//                    idx++;
//                }
//                sym.push(name);
//                name = "";
//            }else if (f.charAt(idx) == ) {
//
//            }
//        }
//        return sb.toString();
//    }
//}
