import java.util.HashMap;

public class FindTheDifference {
    public static char findTheDifference (String a, String b) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int len = b.length();
        for (int i =0; i<len; i++) {
            m.put(b.charAt(i),m.getOrDefault(b.charAt(i), 0)+1);
        }
        for (int i =0; i<len-1; i++) {
            if (m.get(a.charAt(i))-1==0) {
                m.remove(a.charAt(i));
            } else {
                m.replace(a.charAt(i), m.get(a.charAt(i))-1);
            }
        }
        return m.keySet().iterator().next();
    }

    public static char findTheDifference2 (String a, String b) {
        char ans = b.charAt(b.length()-1);
        for (int i =0; i<a.length(); i++) {
            ans ^= a.charAt(i);
            ans ^= b.charAt(i);
        }
        return ans;
    }

    public static char findTheDifference3 (String a, String b) {
        int p = 0;
        int ans = 0;
        for (;p<a.length();p++){
            ans += b.charAt(p)-a.charAt(p);
        }
        return (char)(ans+b.charAt(p));
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("aabb", "aacbb"));
    }
}