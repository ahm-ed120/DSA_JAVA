public class IntegerStack {
    private int [] stack;
    private int top;
    private int size;
    public IntegerStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }
    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = value;
        }
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top--];
        }
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }
    public boolean isEmpty() {
        return top == -1;
    }
}
