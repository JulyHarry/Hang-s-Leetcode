package Trie;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/4/14
 */
public class Trie {
    Trie[] map;
    boolean isEnd;

    public Trie() {
        map = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie[] clone = map;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int j = word.charAt(i) - 'a';
            if (clone[j] == null) {
                clone[j] = new Trie();
            }
            if (i == len - 1) {
                clone[j].isEnd = true;
            }
            clone = clone[j].map;
        }
    }

    public boolean search(String word) {
        Trie[] clone = map;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int j = word.charAt(i) - 'a';
            if (clone[j] == null) {
                return false;
            }
            if (i == len - 1) {
                return clone[j].isEnd;
            }
            clone = clone[j].map;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Trie[] clone = map;
        for (char w : prefix.toCharArray()) {
            int i = w - 'a';
            if (clone[i] == null) {
                return false;
            }
            clone = clone[i].map;
        }
        return true;
    }

}
