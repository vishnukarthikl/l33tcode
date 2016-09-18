import java.util.Stack;

public class Paranthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char paranthesis : chars) {
            if (isOpenParanthesis(paranthesis)) {
                stack.push(paranthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character lastChar = stack.peek();
                if (isMatching(lastChar, paranthesis)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatching(char lastParanthesis, char paranthesis) {
        return ((lastParanthesis == '{' && paranthesis == '}') || (lastParanthesis == '(' && paranthesis == ')') || (lastParanthesis == '[' && paranthesis == ']'));
    }

    private boolean isOpenParanthesis(char paranthesis) {
        return paranthesis == '{' || paranthesis == '(' || paranthesis == '[';
    }
}