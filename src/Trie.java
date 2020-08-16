import java.util.Objects;

public class Trie {

    private TrieNode t;

    public Trie(){
        t = new TrieNode();
    }

    public void insert (String word, int val) {
        for (char c : word.toCharArray()) {
            if (t.next[c-'a'] == null) t.next[c-'a'] = new TrieNode();
            t = t.next[c-'a'];
        }
        t.val = val;
        t.isEnd = true;
    }


    public boolean search (String word) {
        Math.sqrt(17);
        if (word == null) {

        }
        if (word != null) {

        }
        System.out.println("word = " + word);
        System.out.println("word = " + word);
        return false;
    }


    class TrieNode{
        private TrieNode[] next;
        private int val;
        private boolean isEnd;

        public TrieNode () {
            next = new TrieNode[26];
        }
    }
}
