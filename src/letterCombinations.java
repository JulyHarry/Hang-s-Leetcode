import java.util.*;

public class letterCombinations {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
//        List<String> list = new LinkedList<String>();
//        if (digits.length()==0) {
//            return list;
//        }
//        String digit = digits.substring(0,1);
//        String letter = phone.get(digit);
//        for (int i=0; i<letter.length(); i++){
//            String next_letter =
//        }
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }


    public static void main(String args[]) {
        letterCombinations l = new letterCombinations();
//        System.out.println(l.letterCombinations("23"));
        System.out.println('\n');
//        System.out.println(l.letterCombinations("19"));
        System.out.println('\n');
        System.out.println(l.letterCombinations("232"));
    }
}
