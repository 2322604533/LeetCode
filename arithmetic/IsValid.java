package zeus.arithmetic;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid {

    /**
     * 判断括号是否合法
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        // 用队列模拟栈
        Deque<Character> stack = new LinkedList<>();

        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if ( ch == '(') {
                // 检索到"("就入栈
                stack.push(')');
            }
            else if ( ch == '[') {
                stack.push('[');
            }
            else if ( ch == '{') {
                stack.push('}');
            }
            else if (stack.isEmpty() || ch != stack.peek()) {
                // stack.isEmpty() 如果出现"]]]"的情况，栈中的元素为空，但是要返回false;
                // stack.peek() 取栈顶元素但是与之前进入的元素不匹配，返回false，如"(}]"
                return false;
            }
            else {
                // 如果匹配正确就出栈
                stack.pop();
            }
        }
        // 如果全部匹配正确栈就为空
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean res = isValid("(())[[}}");

        System.out.println("res => " + res);
    }
}
