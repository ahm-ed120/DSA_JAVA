class DeQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] queue;

    public DeQueue(int capacity) {
        this.capacity = capacity;
        front = -1;
        rear = -1;
        queue = new int[capacity];
    }

    private boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    private boolean isFull() {
        return (front == 0 && rear == capacity - 1) || front == rear + 1;
    }

    public void addFirst(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        if (rear == -1 && front == -1) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        queue[rear] = value;
    }

    public void addLast(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        if (rear == -1 && front == -1) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        queue[front] = value;
    }

    public int removeFirst() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int firstValue = queue[front];
        if (front == rear) {
            rear = front = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return firstValue;
    }

    public int removeLast() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int lastValue = queue[rear];
        if (front == rear) {
            rear = front = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        return lastValue;
    }
}

public class DoubleEndedQueue {
    public static void main(String[] args) {
        DeQueue deQueue = new DeQueue(5);

        // Adding elements to the queue
        deQueue.addFirst(10);
        deQueue.addFirst(20);
        deQueue.addLast(30);
        deQueue.addLast(40);

        // Removing elements from the queue
        System.out.println("Removed from front: " + deQueue.removeFirst());
        System.out.println("Removed from rear: " + deQueue.removeLast());
        System.out.println("Removed from front: " + deQueue.removeFirst());
        System.out.println("Removed from rear: " + deQueue.removeLast());

    }

}
