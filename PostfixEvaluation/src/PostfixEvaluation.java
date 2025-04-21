public class PostfixEvaluation {

    private static boolean isOperator(String value) {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }

    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidPostfix(String expression) {
        String[] value = expression.trim().split(" ");
        int stackCounter = 0;
        for (String s : value) {
            if (isNumber(s)) {
                stackCounter++;
            } else if (isOperator(s)) {
                if (stackCounter < 2) {
                    return false;
                } else {
                    stackCounter--;
                }
            }
        }
        if (stackCounter == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static int evaluatePostfix(String expression) {
        if (!isValidPostfix(expression)) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
        String[] value = expression.trim().split(" ");
        IntegerStack stack = new IntegerStack(value.length);
        for (String s : value) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else if (isOperator(s)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                switch (s) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("invalid operator: " + s);

                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

    }
}