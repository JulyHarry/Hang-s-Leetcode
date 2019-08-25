import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofPhoneNumber {
    public static List<String> combination(String s){
        LinkedList<String> res = new LinkedList<String>();
        if(s.isEmpty()) return res;
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int k = 0; k < s.length() ; k++){
            int x = s.charAt(k) - '0';
            while (res.peek().length() == k){
                String t = res.remove();
                for(char m : mapping[x].toCharArray())
                    res.add(t+m);
            }
        }
        return res;
    }
}
