import java.util.Scanner;

class ProrityQueue {
    private int capacity;
    private int[] queue;
    private int[] priority;
    private int n;

    public ProrityQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.priority = new int[capacity];
        this.n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean isFull() {
        return n == capacity;
    }

    public void enqueue(int value, int key) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        int i;
        for (i = n -1; i >= 0; i--) {
            if (key < priority[i]) {
                priority[i + 1] = priority[i];
                queue[i + 1] = queue[i];
            } else {
                break;
            }
        }
        priority[i + 1] = key;
        queue[i + 1] = value;
        n++;
    }

    

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = queue[0];

        for (int i = 0; i < n - 1; i++) {
            queue[i] = queue[i + 1];
            priority[i] = priority[i + 1];
        }
        n--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[0];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println();
        System.out.println("Priority Queue: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Value: "+ queue[i] + " " + "Priority: "+priority[i]);
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
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = input.nextInt();
                    System.out.print("Enter priority (lower number = higher priority): ");
                    int key = input.nextInt();
                    queue.enqueue(value,key);
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