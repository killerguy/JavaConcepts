package com.mukul.smallprograms;

import java.util.Stack;

public class BalancedCurlyBrace {

    public static void main(String[] args) {
        System.out.println(isBalanced("[()[]]"));
    }

    private static boolean isBalanced(String datas) {
        Stack<Character> stack = new Stack();
        for (char data : datas.toCharArray()) {
            switch (data) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.peek() != data) {
                        return false;
                    } else {
                        stack.pop();
                    }
            }
        }
        return stack.isEmpty();

    }
}
