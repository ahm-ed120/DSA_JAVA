import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class List {
    Node head;
    Node tail;

    public List() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void insertAfterNode(int key, int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot insert after " + key);
            return;
        }

        Node current = head;
        Node newNode = new Node(data);
        do {
            if (current.data == key) {
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Node with key " + key + " not found. Cannot insert after it.");
    }

    public void insertBeforeNode(int key, int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot insert before " + key);
            return;
        }
        Node current = head;
        Node newNode = new Node(data);
        do {
            if (current.data == key) {
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
                if (current == head) {
                    head = newNode;
                }
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Node with key " + key + " not found. Cannot insert before it.");
    }

    public void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete " + key);
            return;
        }

        Node current = head;
        do {
            if (current.data == key) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                    head.prev = tail;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = head;
                    head.prev = tail;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Node with key " + key + " deleted.");
                return;
            }
            current = current.next;
        } while (current != head);
        System.out.println("Node with key " + key + " not found. Cannot delete it.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data);
            if (current.next != head) {
                System.out.print(" <-> ");
            }
            current = current.next;
        } while (current != head);

        System.out.println(" (circular)");
    }
}

public class DoublyCircularLinkedList {
    public static void main(String[] args) {
        List list = new List();
        Scanner scanner = new Scanner(System.in);
        int choice, data, key;

        do {
            System.out.println("\n--- Doubly Circular Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After Node");
            System.out.println("4. Insert Before Node");
            System.out.println("5. Delete Node");
            System.out.println("6. Display List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at beginning: ");
                    data = scanner.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    data = scanner.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter key after which to insert: ");
                    key = scanner.nextInt();
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    list.insertAfterNode(key, data);
                    break;
                case 4:
                    System.out.print("Enter key before which to insert: ");
                    key = scanner.nextInt();
                    System.out.print("Enter data to insert: ");
                    data = scanner.nextInt();
                    list.insertBeforeNode(key, data);
                    break;
                case 5:
                    System.out.print("Enter key to delete: ");
                    key = scanner.nextInt();
                    list.deleteNode(key);
                    break;
                case 6:
                    System.out.println("Displaying list:");
                    list.display();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}