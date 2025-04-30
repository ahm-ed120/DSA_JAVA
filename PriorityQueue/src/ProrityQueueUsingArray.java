import java.util.Scanner;

class ProrityQueue {
    private int capacity;
    private int[] queue;
    private int front, rear;

    public ProrityQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == 0 && rear == capacity - 1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = value;
        } else {
            int i;
            for (i = rear; i >= front; i--) {
                if (value > queue[rear]) {
                    queue[i + 1] = queue[i];
                }
            }
            queue[i + 1] = value;
            rear++;
        }
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int value = queue[front];

        if (front == rear){
            front = rear = -1;
        } else {
            front++;
        }
        return value;
    }

    public int peek () {
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Priority Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

}

public class ProrityQueueUsingArray {
    public static void main(String[] args) {
        ProrityQueue queue = new ProrityQueue(10);
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPriority Queue Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
            case 1:
                System.out.print("Enter value to enqueue: ");
                int value = input.nextInt();
                queue.enqueue(value);
                break;
            case 2:
                int dequeuedValue = queue.dequeue();
                if (dequeuedValue != -1) {
                System.out.println("Dequeued value: " + dequeuedValue);
                }
                break;
            case 3:
                if (!queue.isEmpty()) {
                System.out.println("Peek value: " + queue.peek());
                } else {
                System.out.println("Queue is empty.");
                }
                break;
            case 4:
                queue.display();
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}