import java.util.HashMap;

public class LengthofLongestSubstring {
    public static int lengthOfLongestSubstring(String s){
        if (s.length() == 0) return 0;
        int len = 1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0,j = 0; i < s.length(); ++i){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            len = Math.max(len, i-j+1);
        }
        return len;
    }
}
