package com.michelle.study.answers;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 *
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 *
 * 举例：
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *

 */
public class Leetcode02 {
    public int evalRPN(String[] tokens) {
        // write code here
        Stack<String> stack = new Stack<>();
        String pattern = "^[+-]?([0-9]+)$";
        for (int i = 0; i < tokens.length; i++) {
            if (Pattern.matches(pattern, tokens[i])) {
                stack.push(tokens[i]);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if("/".equals(tokens[i])) {
                    stack.push(String.valueOf(b/a));
                }
                if("+".equals(tokens[i])) {

                    stack.push(String.valueOf(b+a));
                }
                if("-".equals(tokens[i])) {
                    stack.push(String.valueOf(b-a));
                }
                if("*".equals(tokens[i])) {
                    stack.push(String.valueOf(b*a));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
