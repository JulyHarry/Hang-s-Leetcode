public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        int len = s.length();
        s = s.toLowerCase();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            while (i < j && (s.charAt(i) < 65 || (s.charAt(i) > 90 && s.charAt(i) < 97) || s.charAt(i) > 122)) {
                i++;
            }
            while (i < j && (s.charAt(j) < 65 || (s.charAt(j) > 90 && s.charAt(j) < 97) || s.charAt(j) > 122)) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


//    public static boolean isPalindrome2(String s) {
//        if (s == null || s.length() == 0)
//            return true;
//        int len = s.length();
//        for (int i = 0, j = len - 1; i < j; i++, j--) {
//            while (i < j && (s.charAt(i) < 65 || (s.charAt(i) > 90 && s.charAt(i) < 97) || s.charAt(i) > 122)) {
//                i++;
//            }
//            while (i < j && (s.charAt(j) < 65 || (s.charAt(j) > 90 && s.charAt(j) < 97) || s.charAt(j) > 122)) {
//                j--;
//            }
//            if (s.charAt(i) == s.charAt(j) || s.charAt(i) == s.charAt(j) + 32 || s.charAt(i) == s.charAt(j) - 32) { }
//            if (i>=j) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        String s = "A++++++++++++B";
        System.out.println(isPalindrome(s));
//        System.out.println(isPalindrome2(s));
    }
}
