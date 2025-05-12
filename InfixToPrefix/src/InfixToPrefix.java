class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char value) {
        top += 1;
        stackArray[top] = value;
    }

    public char pop() {
        char value = stackArray[top];
        top -= 1;
        return value;
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

public class InfixToPrefix {

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    private static int getPrecedence(char c) {
        switch (c) {
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

    private static String reverse(String expr) {
        StringBuilder sb = new StringBuilder(expr);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else if (sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }
        

        return sb.toString();
    }

    private static String postfixConvert(String infix) {
        String postfix = "";
        Stack stack = new Stack(infix.length());
        for (char ch : infix.toCharArray()) {
            if (isOperand(ch)) {
                postfix += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop();
                }
                stack.pop();
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
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

    private static String prefixConvert(String infix) {
        String reversedInfix = reverse(infix);
        String postfix = postfixConvert(reversedInfix);
        String prefix = new StringBuilder(postfix).reverse().toString();
        return prefix;
    }

    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)";
        String prefix  = prefixConvert(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefix);

    }
}