package com.stc.backend.utils;

import java.util.Stack;

public class ReverseParentheses {
    public static String process(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(current);
                current = new StringBuilder();
            } else if (ch == ')') {
                current.reverse();
                current = stack.pop().append(current);
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
