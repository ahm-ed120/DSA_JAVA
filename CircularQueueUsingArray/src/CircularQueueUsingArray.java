class CircularQueue{
    int front, rear, capacity;
    int queue[];
    
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.front = this.rear = -1;
        queue = new int[this.capacity];
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue if full.");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int value = queue[front];
        if (front == rear) {
            front = rear = -1; 
        } else {
            front = (front + 1) % capacity;
        }
        return value;
    }

    public void display() {
        if (isEmpty ()){
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i != rear; i = (i+1)%capacity){
            System.out.print(queue[i] + " ");
        }
        System.out.print(queue[rear]);
        System.out.println();
    }
}

public class CircularQueueUsingArray {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display(); // Output: 10 20 30 40 50
        queue.dequeue();
        queue.display(); // Output: 20 30 40 50
        queue.enqueue(60);
        queue.display(); // Output: 20 30 40 50 60
    }
}
