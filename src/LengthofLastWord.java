package Leetcode;

public class LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {return 0;}
        int lastindex = s.lastIndexOf(" ");
        if(lastindex == s.length() - 1){
            String substring = s.substring(0,s.length() - 1);
            return lengthOfLastWord(substring);
        }
        return s.length() - lastindex - 1;
    }

    public static int lengthOfLastWordM2 (String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
