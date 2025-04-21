public class StringStack {
    private String[] stack;
    private int top;
    private int size;

    public StringStack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }

    public void push(String value) {
        if (top == size - 1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = value;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return stack[top--];
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
