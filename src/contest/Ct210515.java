package contest;

/**
 * Description:
 *
 * @author HarryUp
 * @date 2021/5/15
 */
public class Ct210515 {
    public String sortSentence(String s) {
        String[] sp = s.split(" ");
        String[] res = new String[sp.length];
        for (String s1 : sp) {
            int idx = s1.charAt(s1.length() - 1) - '1';
            res[idx] = s1.substring(0, s1.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String r : res) {
            sb.append(r);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - i - 1] = box[i][j];
            }
        }
        for(char[] re : res) {
            for (char r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
        for (int i = 0; i < m; i++) {
            int end = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (res[j][i] == '.') {
                } else if (res[j][i] == '*'){
                    end = j - 1;
                } else if (end != j) {
                    res[end][i] = res[j][i];
                    res[j][i] = '.';
                    end--;
                } else if (end == j) {
                    end--;
                }
            }
        }
        for(char[] re : res) {
            for (char r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
        return res;
    }
}
