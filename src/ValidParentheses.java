import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()){
            if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '('){
                stack.push(')');
            }else if (c == ')' || c == ']' || c == '}'){ // 修改版，当其中有其他字符时，也可以检测 e.g. [hang ] --> True
                if (stack.empty() || c != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
