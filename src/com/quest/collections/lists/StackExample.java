package com.quest.collections.lists;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.search(1));

        while (!stack.empty()) {
            stack.pop();
        }
        System.out.println(stack);
    }
}
