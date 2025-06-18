import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class List {
    private Node head;
    private Node tail;

    List() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfterNode(int key, int data) {
        if (head == null) {
            System.out.println("List is empty, cannot insert after node.");
            return;
        }

        Node current = head;
        Node newNode = new Node(data);

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
        } else {
            System.out.println("Node with value " + key + " not found.");
        }
    }

    public void insertBeforeNode(int key, int data) {
        if (head == null) {
            System.out.println("List is empty, cannot insert after node.");
            return;
        }

        Node current = head;
        Node newNode = new Node(data);

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current != null) {
            newNode.prev = current.prev;
            newNode.next = current;
            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode;
            }
            current.prev = newNode;
        } else {
            System.out.println("Node with value " + key + " not found.");
        }
    }

    public void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty, cannot delete node.");
            return;
        }

        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + key + " not found.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Node with value " + key + " deleted.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        List list = new List();
        Scanner sc = new Scanner(System.in);
        int choice, data, key;

        do {
            System.out.println("\nDoubly Linked List Menu:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After Node");
            System.out.println("4. Insert Before Node");
            System.out.println("5. Delete Node");
            System.out.println("6. Display List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at beginning: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter key after which to insert: ");
                    key = sc.nextInt();
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    list.insertAfterNode(key, data);
                    break;
                case 4:
                    System.out.print("Enter key before which to insert: ");
                    key = sc.nextInt();
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    list.insertBeforeNode(key, data);
                    break;
                case 5:
                    System.out.print("Enter data to delete: ");
                    data = sc.nextInt();
                    list.deleteNode(data);
                    break;
                case 6:
                    list.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
