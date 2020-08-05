package april2020.week2;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class BackSpaceCompare {
    public String stackify(String string) {
        Stack<Character> stack1 = new Stack<>();
        for (Character ch : string.toCharArray()) {
            if (!ch.equals('#'))
                stack1.push(ch);
            else {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            }
        }
        String result = "";
        while (!stack1.empty()) {
            result = stack1.pop() + result;
        }
        return result;
    }

    public boolean backspaceCompare(String S, String T) {
        return stackify(S).equals(stackify(T));
    }

}
