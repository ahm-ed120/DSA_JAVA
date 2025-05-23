class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List {
    private Node head;

    public List() {
        this.head = null;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfterNode(int data, int key) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }
        System.out.println("Key not found");
    }

    public void insertBeforeNode(int data, int key) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == key) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head.next;
        Node previous = head;
        while (current != null) {
            if (current.data == key) {
                previous.next = newNode;
                newNode.next = current;
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Key not found");
    }

    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            System.out.println("Node deleted");
        } else {
            Node current = head.next;
            Node previous = head;
            while (current != null) {
                if (current.data == data) {
                    previous.next = current.next;
                    System.out.println("Node deleted");
                    return;
                }
                previous = current;
                current = current.next;
            }
            System.out.println("Data not found");

        }
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

public class SinglyLinkedList {

    public static void main(String[] args) {
        List list = new List();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Singly Linked List Menu ---");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Beginning");
            System.out.println("3. Insert After Node");
            System.out.println("4. Insert Before Node");
            System.out.println("5. Delete Node");
            System.out.println("6. Display List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter data to insert at end: ");
                    int endData = scanner.nextInt();
                    list.insertAtEnd(endData);
                }
                case 2 -> {
                    System.out.print("Enter data to insert at beginning: ");
                    int begData = scanner.nextInt();
                    list.insertAtBeginning(begData);
                }
                case 3 -> {
                    System.out.print("Enter data to insert: ");
                    int afterData = scanner.nextInt();
                    System.out.print("Enter key after which to insert: ");
                    int afterKey = scanner.nextInt();
                    list.insertAfterNode(afterData, afterKey);
                }
                case 4 -> {
                    System.out.print("Enter data to insert: ");
                    int beforeData = scanner.nextInt();
                    System.out.print("Enter key before which to insert: ");
                    int beforeKey = scanner.nextInt();
                    list.insertBeforeNode(beforeData, beforeKey);
                }
                case 5 -> {
                    System.out.print("Enter data to delete: ");
                    int delData = scanner.nextInt();
                    list.delete(delData);
                }
                case 6 -> list.display();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}