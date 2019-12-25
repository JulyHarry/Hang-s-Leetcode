import java.util.HashMap;

public class RansomNote {
    public static boolean canConstruct(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransom.length(); i++) {
            if (map.get(ransom.charAt(i)) == null || map.get(ransom.charAt(i)) < 1) {
                return false;
            }
            map.replace(ransom.charAt(i), map.get(ransom.charAt(i)) - 1);
        }
        return true;
    }

    public static boolean canConstruct2a(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) return false;
        int caps[] = new int[26];
        for (char c : ransom.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 'a'] = index + 1;
        }
        return true;
    }

    public static boolean canConstruct2b(String ransom, String magazine) {
        int[] num=new int[26]; //定义一个int型数组，来统计每个字符出现的次数
        for(int i=0;i<magazine.length();i++){
            num[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransom.length();i++){
            if(num[ransom.charAt(i)-'a']==0){ //如果该字母出现次数为0，则返回false
                return false;
            }
            num[ransom.charAt(i)-'a']--; //否则将该字母可用次数减一
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "aabb";
        String b = "abdcdfasf";
        System.out.println(canConstruct(a, b));
        System.out.println(canConstruct2a(a, b));
    }
}