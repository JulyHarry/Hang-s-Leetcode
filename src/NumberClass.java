import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2020/8/31 21:14
 *
 * @author iJuly
 * @version 1.0
 */

public class NumberClass {


    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * <a href="">https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/</a>
     * @param s Given string.
     * @return The first unique character.
     */
    public char firstUniqCharHashTable(String s) {
        int[] alpha = new int[256];
        for (char c : s.toCharArray()) {
            alpha[c]++;
        }
        for (char c : s.toCharArray()) {
            if (alpha[c] == 1) return c;
        }
        return ' ';
    }

    public char firstUniqCharOnlyAlphaHashTable(String s) {
        int[] alpha = new int[26];
        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (alpha[c - 'a'] == 1) return c;
        }
        return ' ';
    }

    public char firstUniqCharHashMap(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (map.get(c)) return c;
        }
        return ' ';
    }

    public char firstUniqCharOrderHashMap(String s) {
        HashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
