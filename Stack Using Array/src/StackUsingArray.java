class Stack {
    private int maxSize;
    private int[] stack;
    private int top;
    
    public Stack(int size){
        this.maxSize = size;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push (int value){
        if (isFull()){
            System.out.println("Stack is full. Can not push " + value);
        }
        else {
            stack[++top] = value;
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return stack[top];
        }
    }
}
public class StackUsingArray {
    public static void main(String[] args){
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Stack is full: " + stack.isFull());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack is empty: " + stack.isEmpty());
    }

}