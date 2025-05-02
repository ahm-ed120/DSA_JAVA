class Queue {
    private int queue[];
    private int front, rear, capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[this.capacity];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        if (front == -1 && rear == -1) {
            front = rear = 0;
        } else {
            rear += 1;
        }
        queue[rear] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is full.");
            return -1;
        }
        int value = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front += 1;
        }
        return value;
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[rear];
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Queue is full: " + queue.isFull());
        System.out.println("Queue is empty: " + queue.isEmpty());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Front element: " + queue.peekFront());
        System.out.println("Rear element: " + queue.peekRear());
    }
}