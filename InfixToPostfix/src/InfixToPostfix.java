class Stack {
    private int top;
    private int capacity;
    private char[] stack;

    public Stack(int size) {
        capacity = size;
        stack = new char[capacity];
        top = -1;
    }

    public void push(char element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = element;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        }
        return stack[top--];
    }

    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return '\0';
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class InfixToPostfix {
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private static String infixToPostfix(String infix) {
        String postfix = "";
        Stack stack = new Stack(infix.length());
        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix += stack.pop();
                }
                stack.push(ch);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }

        return postfix;

    }

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + postfix);
    }

}