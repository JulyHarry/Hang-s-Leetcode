import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class searchWord {
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> set = new HashSet<String>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (check(word, board, i, j, 0)) {
                        set.add(word);
                        break;
                    }
                }
            }
        }
        List<String> res = new ArrayList<>(set);
        return res;
    }

    private boolean check (String word, char[][] board, int i, int j, int ptr) {
        if (ptr == word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '#') return false;
        if (board[i][j] == word.charAt(ptr)) {
            char save = board[i][j];
            board[i][j] = '#';
            boolean tmp = check(word, board, i + 1, j, ptr + 1) || check(word, board, i - 1, j, ptr + 1) || check(word, board, i, j - 1, ptr + 1) || check(word, board, i, j + 1, ptr + 1);
            board[i][j] = save;
            return tmp;
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] boards = {{'a','b'},{'c','d'}};
//        String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
//        searchWord s = new searchWord();
//        List<String> list = s.findWords(boards, words);
//        System.out.println(list);

        List<Integer> res = new ArrayList<>();
        res.add(1);
        System.out.println(res.contains(1));

        for (int i = 0; i < 3; ++i) {
            if (res.contains(i)) break;
            for (int j = 0; j < 5; ++j) {
                if (j/2 == 0) {
                    res.add(j);
                    break;
                }
            }
        }

        System.out.println(res);
    }
}